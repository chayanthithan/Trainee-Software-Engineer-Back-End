package com.example.admin_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends RuntimeException{
    private HttpStatus httpStatus;
    private String headerMessage;

    public ServiceException(String message, HttpStatus httpStatus, String headerMessage) {
        super(message);
        this.httpStatus = httpStatus;
        this.headerMessage = headerMessage;
    }
}
