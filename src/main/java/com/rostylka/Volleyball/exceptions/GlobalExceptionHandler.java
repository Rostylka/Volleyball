package com.rostylka.Volleyball.exceptions;

import com.rostylka.Volleyball.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponseDto handler(EntityNotFoundException e) {
        return new ExceptionResponseDto(e.getHttpStatus(), e.getMessage());
    }
}
