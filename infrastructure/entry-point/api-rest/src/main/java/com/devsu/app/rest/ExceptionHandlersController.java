package com.devsu.app.rest;

import com.devsu.app.model.config.DevsuException;
import com.devsu.app.rest.config.ValidationConstants;
import com.devsu.helper.constant.ExceptionConstant;
import com.devsu.helper.dto.ApiResponseDto;
import com.devsu.helper.dto.ResponseDto;
import com.devsu.helper.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlersController {

     private final ExceptionUtil exceptionUtil;

     @ExceptionHandler({DevsuException.class})
     public ResponseEntity<ApiResponseDto> handleDevsuException(DevsuException ex) {
          ApiResponseDto response = ApiResponseDto.builder()
                  .status(ex.getStatus())
                  .code(ex.getCode())
                  .message(ex.getMessage()).build();
          return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getStatus()));
     }

     @ExceptionHandler({Exception.class})
     public ResponseEntity<ApiResponseDto> handleException(Exception ex) {
          ApiResponseDto response = ApiResponseDto.builder()
                  .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                  .code(ExceptionConstant.DEV0002)
                  .message(ex.getMessage()).build();
          return new ResponseEntity<>(response, HttpStatus.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
     }

     @ExceptionHandler({MethodArgumentNotValidException.class})
     public ResponseEntity<ResponseDto<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
          ResponseDto<Void> response = this.exceptionUtil.createResponseFromFieldErrors(ex.getFieldErrors());
          return new ResponseEntity<>(response, HttpStatus.valueOf(HttpStatus.BAD_REQUEST.value()));
     }
}
