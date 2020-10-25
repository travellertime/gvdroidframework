package com.gvdroidframework.base.component;

import java.io.Serializable;

public abstract class XfaceGenericRequestDTO implements Serializable {

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
