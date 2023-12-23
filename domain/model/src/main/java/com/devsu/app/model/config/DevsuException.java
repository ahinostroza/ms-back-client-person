package com.devsu.app.model.config;

import lombok.Getter;

@Getter
public class DevsuException extends RuntimeException {

    private final int status;
    private final String code;
    private final String message;

    public DevsuException(int status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public DevsuException(int status, String code, String message, Throwable e) {
        super(message, e);
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
