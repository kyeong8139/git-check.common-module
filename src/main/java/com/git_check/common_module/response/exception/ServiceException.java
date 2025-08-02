package com.git_check.common_module.response.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;

    public ServiceException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }   
}
