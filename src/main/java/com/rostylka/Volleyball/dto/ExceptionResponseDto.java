package com.rostylka.Volleyball.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionResponseDto {

    private final int httpStatusCode;
    private final String message;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime time = LocalDateTime.now();

    public ExceptionResponseDto(int httpStatusCode, String message) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
    }
}
