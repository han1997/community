package com.hhy.community.community.exception;

/**
 * @author hhy1997
 * 2020/2/5
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(CustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
