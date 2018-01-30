package com.cj.vote.utils;

public class InvalidCraftException extends RuntimeException {
    @Override
    public String getMessage() {
        return "无此作品";
    }
}
