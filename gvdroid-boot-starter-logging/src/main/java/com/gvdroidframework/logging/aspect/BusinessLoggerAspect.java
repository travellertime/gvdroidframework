package com.gvdroidframework.logging.aspect;

import com.alibaba.fastjson.JSON;
import com.gvdroidframework.logging.annotation.BusinessLogger;
import com.gvdroidframework.logging.component.BusinessLoggingDTO;
import com.gvdroidframework.logging.core.LoggingTemplate;
import com.gvdroidframework.util.ClassUtils;
import com.gvdroidframework.base.component.Context;
import com.gvdroidframework.base.component.Response;
import com.gvdroidframework.base.component.Status;
import com.gvdroidframework.base.constant.ErrorCode;
import com.gvdroidframework.base.exception.BaseException;
import com.gvdroidframework.base.exception.RunException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * BusinessLogger注解切面拦截
 *
 * @author XIEZHONG
 */
@Aspect
@Component
@Order(-1000)
public class BusinessLoggerAspect {

    @Autowired(required = false)
    private LoggingTemplate<BusinessLoggingDTO> loggingTemplate;

    @Pointcut("@annotation(com.gvdroidframework.cloud.logging.annotation.BusinessLogger)")
    public void loggerPointCut() {
    }

    @Around("loggerPointCut()")
    public Object loggingHandler(ProceedingJoinPoint proceedingJoinPoint) {
        long startTime = System.currentTimeMillis();
        Logger logger = null;
        Object target = proceedingJoinPoint.getTarget(), requestDTO = null, responseDTO = null;
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        BusinessLogger businessLogger = method.getAnnotation(BusinessLogger.class);
        Context context = null;
        String requestString = null;
        String targetClassName = null;

        try {
            // 得到请求对象
            for (Object o : proceedingJoinPoint.getArgs()) {
//                Class<?> clazz = o.getClass();
                //TODO 现在使用了Wrapper需要重写一下这里。
                requestDTO = o.getClass();
//                Class<?> superclass = o.getClass().getSuperclass();
//                boolean isRequiredClass = superclass.equals(XfaceGenericRequestDTO.class);
//                if (isRequiredClass) {
//                    requestDTO = o;
//                    break;
//                }
            }
            if (null == requestDTO) {
                throw new RunException("requestDTO cannot satisfied required info, check with your supervisor.", "775", ErrorCode.EXCEPTION, startTime);
            }

            // 得到xface wrapper层的日志定义字段，用于输入日志
            Field logField = target.getClass().getDeclaredField("log");
            targetClassName = target.getClass().getName();
            logField.setAccessible(true);
            logger = (Logger) logField.get(target);

            // 得到请求中的SessionContext
            context = ClassUtils.getObjFiledValue(requestDTO, "context", Context.class);

            logger.info("Process Xface Start");
            requestString = JSON.toJSONString(requestDTO);
            logger.info("RequestDTO=" + requestString);

            // 不允许sessionContext为空
            if (null == context) {
                throw new BaseException("sessionContext cannot be null, please refer to api docs to get more info.", "777", ErrorCode.EXCEPTION, startTime);
            }

            if (StringUtils.isEmpty(context.getEntityId())) {
                throw new BaseException("entityId cannot be null in sessionContext", "777", ErrorCode.EXCEPTION, startTime);
            }

//            // 当乐观锁为true的时候，更新序号不允许为空
//            if (!CommonUtils.isEmptyOrZero(sessionContext.getOptimistic()) && CommonUtils.isEmptyOrZero(sessionContext.getUpdateNo())) {
//                throw new BaseException("updateNo cannot be null while optimistic is true.", "777", ErrorCode.EXCEPTION, startTime);
//            }

            // 业务日志中的服务编号字段不允许为空
            if (StringUtils.isEmpty(businessLogger.value())) {
                throw new BaseException("日志注解中的value字段必须填入接口的serviceCode值。", "777", ErrorCode.EXCEPTION, startTime);
            }
            context.setServiceId(businessLogger.value());

            // 继续执行并得到响应对象
            responseDTO = proceedingJoinPoint.proceed();
        } catch (NoSuchFieldException e) {
            String replyText = "there is no log field defined in xface wrapper. contract developer to fix the fatal bug.";
            String replyCode = "777";
            responseDTO = getErrorResponse(replyText, replyCode);
            throw new RunException(replyText, replyCode, ErrorCode.EXCEPTION, startTime);
        } catch (BaseException e) {
            responseDTO = getErrorResponse(e);
            throw new BaseException(e.getMessage(), e.getErrorCode(), ErrorCode.FAILURE, startTime);
        } catch (Throwable e) {
            responseDTO = getErrorResponse(e);
            throw new RunException(e.getMessage(), e, ErrorCode.EXCEPTION, startTime);
        } finally {

            // 最终执行计算执行时间并将时间设置进入transactionStatus中，并打印日志
            doFinally(startTime,
                    logger,
                    responseDTO,
                    context,
                    requestString,
                    targetClassName);
        }

        return responseDTO;
    }

    /**
     * 当AOP拦截的方法内部或者调用的其它类出现异常的时候，在这里捕获异常，并将异常封装成标准输出打印成日志
     *
     * @param e 自定义异常
     * @return 标准输出对象
     */
    private Object getErrorResponse(BaseException e) {
//        XfaceGenericResponseDTO responseDTO = new XfaceGenericResponseDTO();
//        TransactionStatus transactionStatus = new TransactionStatus();
//        transactionStatus.setError(e.getErrorDesc(), e.getErrorCode());
//        responseDTO.setTransactionStatus(transactionStatus);
//        return responseDTO;
        return new Response<>(null, new Status(e.getErrorDesc(), e.getErrorCode()));
    }

    /**
     * 当AOP拦截的方法内部或者调用的其它类出现异常的时候，在这里捕获异常，并将异常封装成标准输出打印成日志
     *
     * @param e 系统运行时的未知异常
     * @return 标准输出对象
     */
    private Object getErrorResponse(Throwable e) {
//        XfaceGenericResponseDTO responseDTO = new XfaceGenericResponseDTO();
//        TransactionStatus transactionStatus = new TransactionStatus();
//        transactionStatus.setError(ErrorCode.ERROR_MSG_999, ErrorCode.ERROR_CODE_999, ErrorCode.EXCEPTION);
//        transactionStatus.setMemo(e.getMessage());
//        responseDTO.setTransactionStatus(transactionStatus);
//        return responseDTO;
        return new Response<>(null, new Status(ErrorCode.EXCEPTION, ErrorCode.ERROR_MSG_999, ErrorCode.ERROR_CODE_999, e.getMessage()));
    }

    /**
     * 当AOP拦截的方法内部或者调用的其它类出现异常的时候，在这里捕获异常，并将异常封装成标准输出打印成日志
     *
     * @param replyText 自定义错误描述
     * @param replyCode 自定义错误代码
     * @return 标准输出对象
     */
    private Object getErrorResponse(String replyText, String replyCode) {
//        XfaceGenericResponseDTO responseDTO = new XfaceGenericResponseDTO();
//        TransactionStatus transactionStatus = new TransactionStatus();
//
//        if (replyCode.equals(ErrorCode.ERROR_CODE_999)) {
//            transactionStatus.setError(ErrorCode.ERROR_MSG_999, replyCode, ErrorCode.EXCEPTION);
//            transactionStatus.setMemo(replyText);
//        } else {
//            transactionStatus.setError(replyText, replyCode);
//        }
//        responseDTO.setTransactionStatus(transactionStatus);
//        return responseDTO;
        if (replyCode.equals(ErrorCode.ERROR_CODE_999)) {
            return new Response<>(null, new Status(ErrorCode.EXCEPTION, ErrorCode.ERROR_MSG_999, replyCode, replyText));
        } else {
            return new Response<>(null, new Status(replyText, replyCode));
        }
    }

    /**
     * @param startTime       请求开始的时间
     * @param logger          接口中的日志定义
     * @param responseDTO     响应对象
     * @param context         上下文
     * @param requestString   请求对象文本
     * @param targetClassName 目标类的名称
     */
    private void doFinally(long startTime,
                           Logger logger,
                           Object responseDTO,
                           Context context,
                           String requestString,
                           String targetClassName) {
        Status status;

        if (null == logger) {
            return;
        }

        status = ClassUtils.getObjFiledValue(responseDTO, "status", Status.class);
        long endTime = System.currentTimeMillis();
        if (null != status) {
            status.setDuration(endTime - startTime);
        }
        // write response logs to local file.
        String responseString = JSON.toJSONString(responseDTO);
        logger.info("ResponseDTO=" + responseString);
        if (status != null) {
            switch (status.getErrorCode()) {
                case ErrorCode.FAILURE: {
                    logger.info("Process Xface End With Defined Exception.");
                    break;
                }
                case ErrorCode.EXCEPTION: {
                    logger.info("Process Xface End With Runtime Fatal Exception.");
                    break;
                }
                default: {
                    logger.info("Process Xface End With Succeed");
                    break;
                }
            }
        }

        // 如果配置了消息队列和开启了业务日志则将写入日志异步写入MQ
        if (null != loggingTemplate && null != context) {
            BusinessLoggingDTO dto = new BusinessLoggingDTO();
            dtoBuilder(dto, context, requestString, responseString, startTime, endTime);
            loggingTemplate.save(dto, targetClassName);
        }
    }

    private void dtoBuilder(BusinessLoggingDTO dto, Context context, String requestString, String responseString, long startTime, long endTime) {
        dto.setChannel(context.getChannel());
        dto.setEntityId(String.valueOf(context.getEntityId()));
        dto.setLocalDate(context.getLocalDateTime());
        dto.setRefUserNo(context.getUserReferenceNo());
        dto.setRefTxnNo(context.getTxnReferenceNo());
        dto.setRequestDTO(requestString);
        dto.setResponseDTO(responseString);
        dto.setServiceId(context.getServiceId());
        dto.setStartTime(startTime);
        dto.setEndTime(endTime);
        dto.setUserId(context.getUserId());
        dto.setOrgId(context.getOrgId());
        dto.setIp(context.getIp());
        dto.setLbs(context.getLbs());
    }
}
