package com.hhy.community.community.exception;

/**
 * @author hhy1997
 * 2020/2/5
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("你找的问题不存在!"),
    USER_NOT_FOUNT("该用户不存在");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
