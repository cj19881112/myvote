package com.cj.vote.utils;

public class InvalidSenseException extends RuntimeException {
    @Override
    public String getMessage() {
        return "无此场景";
    }
}
