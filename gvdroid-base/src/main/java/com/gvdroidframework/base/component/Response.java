package com.gvdroidframework.base.component;

import java.io.Serializable;

public final class Response<T> implements Serializable {
    private Status status;
    private T body;

    public Response(T t, Status status) {
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

    public static <T> Response<T> body(T body) {
        return body(body, new Status());
    }

    public static <T> Response<T> body(T body, Status status) {
        return new Response<>(body, status);
    }
}
