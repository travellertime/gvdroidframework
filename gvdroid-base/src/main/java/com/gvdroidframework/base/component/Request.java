package com.gvdroidframework.base.component;

import java.io.Serializable;

public final class Request<T> implements Serializable {
    private Context context;
    private T body;


//    public Request(Context context, T body) {
//        this.context = context;
//        this.body = body;
//    }
//
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
//
//    public static <T> Request<T> body(T body) {
//        return body(new Context(), body);
//    }
//
//    public static <T> Request<T> body(Context context, T body) {
//        return new Request<>(context, body);
//    }
}
