package com.gvdroidframework.boot.autoconfigure.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gvdroidframework.base.component.Response;
import com.gvdroidframework.base.component.Status;
import com.gvdroidframework.base.constant.ErrorCode;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 接口字段校验拦截器
 *
 * @author Colin
 * @since 2.0.0
 */
@ControllerAdvice
@Order(-999)
public class RequestValidationAdviceAutoConfiguration {

    /**
     * Controller字段注解异常捕获后的处理
     *
     * @param e MethodArgumentNotValidException
     * @return ResponseEntity
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Response<?>> handleBindException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(toStr(e), HttpStatus.OK);
    }

    /**
     * 把校验异常转换为字符串
     *
     * @param e MethodArgumentNotValidException
     * @return TransactionStatus
     */
    private Response<?> toStr(MethodArgumentNotValidException e) {
        Status status = new Status();
        Response<?> response = new Response<>(null, status);

        String errors = e.getBindingResult().getFieldErrors().stream()
                .map(ex -> ex.getField() + ":" + ex.getDefaultMessage())
                .reduce("", (s1, s2) -> {
                    if (s1.equals("")) return s2;
                    return s1 + ", " + s2;
                });

        status.setError(errors, ErrorCode.ERROR_CODE_901);
        response.setStatus(status);
        return response;
    }

    /**
     * Controller字段枚举值错误捕获处理
     *
     * @param e InvalidFormatException
     * @return ResponseEntity
     */
    @ExceptionHandler(value = InvalidFormatException.class)
    public ResponseEntity<Response<?>> handleEnumBindException(InvalidFormatException e) {
        return new ResponseEntity<>(toStr(e), HttpStatus.BAD_REQUEST);
    }

    /**
     * 把枚举值错误的信息转换为字符串。
     *
     * @param e 格式错误异常
     * @return XfaceGenericResponseDTO
     */
    private Response<?> toStr(InvalidFormatException e) {
        Status status = new Status(ErrorCode.FAILURE, ErrorCode.ERROR_CODE_901, e.getMessage());
        Response<?> responseDTO = new Response<>(null, status);
        responseDTO.setStatus(status);
        return responseDTO;
    }
}
