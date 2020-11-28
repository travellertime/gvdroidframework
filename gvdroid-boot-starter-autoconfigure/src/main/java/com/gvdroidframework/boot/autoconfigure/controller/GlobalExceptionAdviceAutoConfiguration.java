package com.gvdroidframework.boot.autoconfigure.controller;


import com.gvdroidframework.base.component.R;
import com.gvdroidframework.base.component.Status;
import com.gvdroidframework.base.constant.ErrorCode;
import com.gvdroidframework.base.exception.BaseException;
import com.gvdroidframework.base.exception.RunException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Runtime异常拦处理，自定义异常会返回自定义错误回复代码以及错误描述，其它异常会返回通知管理员。
 * 自定义异常的时候返回的错误码为1，其它异常返回的错误码为9。
 * {@link GlobalExceptionAdviceAutoConfiguration}和{@link RequestValidationAdviceAutoConfiguration}都使用了{@link ControllerAdvice}注解，在处理的时候有先后顺序，因此需要设置Order。
 * 先处理ValidationAdvice再处理GlobalExceptionAdvice
 *
 * @author Colin
 * @since 2.0.0
 */
@ControllerAdvice
@Order(-998)
public class GlobalExceptionAdviceAutoConfiguration {

    /**
     * 异常拦截
     *
     * @param e Any RuntimeException
     * @return ResponseEntity
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<R<?>> handleException(Exception e) {
        return fetchGenericResponse(e);
    }

    /**
     * 异常处理
     *
     * @param e Any RuntimeException
     * @return TransactionStatus
     */
    private ResponseEntity<R<?>> fetchGenericResponse(Exception e) {
        Status status = new Status();
        R<?> r = new R<>(null, status);

        // 自定义BaseException异常
        if (e instanceof BaseException) {
            return getBaseException((BaseException) e, r, status);
        }

        // 自定义RunException异常
        if (e instanceof RunException) {
            return getRunException((RunException) e, r, status);
        }

        // 系统运行时异常
        return getRuntimeException(e, r, status);
    }

    /**
     * 获取运行时异常的错误信息
     *
     * @param e        Exception
     * @param r XfaceGenericResponseDTO
     * @param status   Status
     * @return XfaceGenericResponseDTO and ResponseEntity with HttpStatus 200
     */
    private ResponseEntity<R<?>> getRuntimeException(Exception e, R<?> r, Status status) {
        fillTransactionStatus(e, r, status);
        e.printStackTrace();
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    /**
     * 获取运行时的未知异常
     *
     * @param e        RunException
     * @param r XfaceGenericResponseDTO
     * @param status   TransactionStatus
     * @return ResponseEntity
     */
    private ResponseEntity<R<?>> getRunException(RunException e, R<?> r, Status status) {
        status.setDuration(e.getTimeStamp() != 0L ? System.currentTimeMillis() - e.getTimeStamp() : 0L);
        fillTransactionStatus(e, r, status);
        e.printStackTrace();
        return new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 获取自定义异常的错误信息
     *
     * @param e        Exception
     * @param r XfaceGenericResponseDTO
     * @param status   TransactionStatus
     * @return XfaceGenericResponseDTO
     */
    private ResponseEntity<R<?>> getBaseException(BaseException e, R<?> r, Status status) {
        status.setError(e.getErrorDesc(), e.getErrorCode());
        status.setDuration(e.getTimeStamp() != 0L ? System.currentTimeMillis() - e.getTimeStamp() : 0L);
        r.setStatus(status);
        e.printStackTrace();
//        return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    /**
     * 根据传入的Exception填充TransactionStatus
     *
     * @param e        Exception
     * @param r XfaceGenericResponseDTO
     * @param status   TransactionStatus
     */
    private void fillTransactionStatus(Exception e, R<?> r, Status status) {
        status.setError(ErrorCode.ERROR_MSG_999, ErrorCode.ERROR_CODE_999, ErrorCode.EXCEPTION);
        status.setMemo(e.getMessage());
        r.setStatus(status);
    }
}
