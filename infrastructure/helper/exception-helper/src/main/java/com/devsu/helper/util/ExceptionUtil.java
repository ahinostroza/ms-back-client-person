package com.devsu.helper.util;

import com.devsu.helper.MessageHelper;
import com.devsu.helper.constant.ExceptionConstant;
import com.devsu.helper.dto.FieldErrorDto;
import com.devsu.helper.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ExceptionUtil {
    private final MessageHelper messageHelper;

    public FieldErrorDto toFieldError(FieldError error) {
        String code = error.getDefaultMessage();
        String message;
        message = this.messageHelper.getMessage(code);
        var propertyPath = error.getField();
        return new FieldErrorDto(propertyPath, message);
    }

    public ResponseDto<Void> createResponseFromFieldErrors(List<FieldError> errors) {
        return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), ExceptionConstant.DEV0001,
                this.messageHelper.getFormatedMessage(ExceptionConstant.DEV0001, errors.toArray()),
                errors.stream().map(this::toFieldError).collect(Collectors.toList()));
    }
}
