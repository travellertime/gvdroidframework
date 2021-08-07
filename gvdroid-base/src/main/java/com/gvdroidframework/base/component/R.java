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
package com.gvdroidframework.base.component;

import java.io.Serializable;

/**
 * 返回对象封装类
 *
 * @author Colin
 * @since 2.0.0
 *
 * @param <T> 返回对象
 */
public final class R<T> implements Serializable {
    private Status status;
    private T body;

    public R(){

    }

    public R(T t) {
        this.body = t;
        this.status = new Status();
    }

    public R(T t, Status status) {
        this.body = t;
        this.status = status;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static <T> R<T> body(T body) {
        return new R<>(body);
    }

    public static <T> R<T> body(T body, Status status) {
        return new R<>(body, status);
    }
}
