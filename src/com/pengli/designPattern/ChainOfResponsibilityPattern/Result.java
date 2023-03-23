package com.pengli.designPattern.ChainOfResponsibilityPattern;

public class Result {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(String message) {
        this.message = message;
    }
}
