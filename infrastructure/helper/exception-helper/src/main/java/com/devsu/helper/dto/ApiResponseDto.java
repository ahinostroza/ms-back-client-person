package com.devsu.helper.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
public class ApiResponseDto {
    private OffsetDateTime timestamp;
    private int status;
    private String code;
    private String message;
    private String path;
    private List<FieldErrorDto> fields;
}
