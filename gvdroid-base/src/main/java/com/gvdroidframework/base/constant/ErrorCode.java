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
package com.gvdroidframework.base.constant;

/**
 * TransactionStatus的错误代码常量定义
 *
 * @author Colin
 * @since 1.0.0
 */
public interface ErrorCode {

    /**
     * get succeed.
     * value = "0"
     */
    String SUCCESS = "0";
    /**
     * Runtime Exception.
     * value = "1"
     */
    String FAILURE = "1";

    /**
     * Unauthorized
     */
    String INVALID_ACCESS_TOKEN = "2";

    /**
     *
     */
    String INVALID_REFRESH_TOKEN = "3";

    /**
     * Fatal Exception.
     * value = "9"
     */
    String EXCEPTION = "9";

    /**
     * 输入参数校验错误，请检查
     */
    String ERROR_CODE_901 = "901";
    String ERROR_MSG_901 = "input parameter failed";

    /**
     * 实体编号不能为空
     */
    String ERROR_CODE_902 = "902";
    String ERROR_MSG_902 = "entityId cannot be null";

    /**
     * 主键字段不能为空
     */
    String ERROR_CODE_903 = "903";
    String ERROR_MSG_903 = "primary key cannot be null";



    /**
     * 系统错误请联系管理员
     */
    String ERROR_CODE_999 = "999";
    String ERROR_MSG_999 = "system fatal error, please contact administrator.";

}
