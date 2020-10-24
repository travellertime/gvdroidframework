package com.gvdroidframework.base.component;

import javax.validation.Valid;
import java.io.Serializable;

public final class Request<T> implements Serializable {

    private Context context;

    @Valid
    private T body;

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

}
