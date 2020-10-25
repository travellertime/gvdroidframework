package com.gvdroidframework.base.component;

import java.io.Serializable;

public final class R<T> implements Serializable {
    private Status status;
    private T body;

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
