/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gvdroidframework.boot.autoconfigure.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gvdroidframework.base.component.R;
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
    public ResponseEntity<R<?>> handleBindException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(toStr(e), HttpStatus.OK);
    }

    /**
     * 把校验异常转换为字符串
     *
     * @param e MethodArgumentNotValidException
     * @return TransactionStatus
     */
    private R<?> toStr(MethodArgumentNotValidException e) {
        Status status = new Status();
        R<?> r = new R<>(null, status);

        String errors = e.getBindingResult().getFieldErrors().stream()
                .map(ex -> ex.getField() + ":" + ex.getDefaultMessage())
                .reduce("", (s1, s2) -> {
                    if (s1.equals("")) return s2;
                    return s1 + ", " + s2;
                });

        status.setError(errors, ErrorCode.ERROR_CODE_901);
        r.setStatus(status);
        return r;
    }

    /**
     * Controller字段枚举值错误捕获处理
     *
     * @param e InvalidFormatException
     * @return ResponseEntity
     */
    @ExceptionHandler(value = InvalidFormatException.class)
    public ResponseEntity<R<?>> handleEnumBindException(InvalidFormatException e) {
        return new ResponseEntity<>(toStr(e), HttpStatus.BAD_REQUEST);
    }

    /**
     * 把枚举值错误的信息转换为字符串。
     *
     * @param e 格式错误异常
     * @return XfaceGenericResponseDTO
     */
    private R<?> toStr(InvalidFormatException e) {
        Status status = new Status(ErrorCode.FAILURE, ErrorCode.ERROR_CODE_901, e.getMessage());
        R<?> rDTO = new R<>(null, status);
        rDTO.setStatus(status);
        return rDTO;
    }
}
