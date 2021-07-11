package com.gvdroid.simple.gateway.handler;

import com.gvdroidframework.base.component.R;
import com.gvdroidframework.base.component.Status;
import com.gvdroidframework.base.constant.ErrorCode;
import com.gvdroidframework.base.exception.BaseException;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 网关异常处理
 */
public class CustomErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {
    public CustomErrorWebExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources, ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resources, errorProperties, applicationContext);
    }

    /**
     * 重写输出
     *
     * @param request 流请求
     * @return 流响应
     */
    @Override
    protected Mono<ServerResponse> renderErrorResponse(ServerRequest request) {

        Throwable throwable = super.getError(request);
        if (throwable instanceof BaseException) {
            return ServerResponse
                    .status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(R.body(null, buildStatus((BaseException) throwable))));
        } else {
            Map<String, Object> errors = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
            return ServerResponse
                    .status(getHttpStatus(errors))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(R.body(null, buildStatus(throwable))));
        }
    }

    private Status buildStatus(Throwable e) {
        Status status = new Status();
        if (e != null) {
            status.setError(e.getMessage(), "999", ErrorCode.EXCEPTION);
        }

        return status;
    }

    private Status buildStatus(BaseException e) {
        Status status = new Status();
        if (e != null) {
            status.setError(e.getErrorDesc(), e.getErrorCode(), e.getErrorLevel());
        }
        return status;
    }
}
