package com.example.user_management_service.exception;

import lombok.Getter;

public class ServiceException extends RuntimeException{
    @Getter
    private String httpStatus;
    @Getter
    private String headerMessage;

    public ServiceException(String message,String httpStatus, String headerMessage) {
        super(message);
        this.httpStatus = httpStatus;
        this.headerMessage = headerMessage;
    }
}
