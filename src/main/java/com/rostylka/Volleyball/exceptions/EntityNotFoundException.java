package com.rostylka.Volleyball.exceptions;

import lombok.Getter;

@Getter
public abstract class EntityNotFoundException extends RuntimeException{
    public abstract int getHttpStatus();
    public abstract String getMessage();

}
