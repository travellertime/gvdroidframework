package com.gvdroidframework.logging.core;

public interface LoggingTemplate<T> {
    void save(T t, String category);
}
