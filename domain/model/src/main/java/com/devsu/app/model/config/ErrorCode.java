package com.devsu.app.model.config;

import lombok.Getter;

@Getter
public enum ErrorCode {
    D401000("D401-000", "Unauthorized");

    private final String code;
    private final String log;
    ErrorCode(String code, String log) {
        this.code = code;
        this.log = log;
    }
}
