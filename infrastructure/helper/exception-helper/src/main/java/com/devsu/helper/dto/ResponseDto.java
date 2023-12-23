package com.devsu.helper.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ResponseDto<T> {
    private int status;
    private String code;
    private String message;
    private List<FieldErrorDto> fieldErrors;
    private T data;

    public ResponseDto(int status, String code, String message, List<FieldErrorDto> fieldErrors, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.fieldErrors = fieldErrors;
        this.data = data;
    }

    public ResponseDto(int status, String code, String message, List<FieldErrorDto> fieldErrors) {
        this(status, code, message, fieldErrors, null);
    }
}
