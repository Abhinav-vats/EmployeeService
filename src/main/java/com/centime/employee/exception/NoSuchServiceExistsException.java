package com.centime.employee.exception;

public class NoSuchServiceExistsException extends RuntimeException {
    private String message;

    public NoSuchServiceExistsException() {}

    public NoSuchServiceExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
