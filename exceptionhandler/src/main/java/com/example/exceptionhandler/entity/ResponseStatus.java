package com.example.exceptionhandler.entity;

public enum ResponseStatus {
    SUCCESS(2000),
    ERR(2001),
    TIME_OUT(2002);

    private int code;

    ResponseStatus(int code) {
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
