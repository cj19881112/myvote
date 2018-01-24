package com.cj.vote.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ret<T> {
    public static <T> Ret<T> ok(T data) {
        Ret<T> ret = new Ret<>();
        ret.setData(data);
        ret.setSuccess(true);
        return ret;
    }

    public static Ret<Void> ok() {
        Ret<Void> ret = new Ret<>();
        ret.setData(null);
        ret.setSuccess(true);
        return ret;
    }


    public static <T> Ret<T> err(String msg) {
        Ret<T> ret = new Ret<>();
        ret.setSuccess(false);
        ret.setMsg(msg);
        return ret;
    }

    private T data;
    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
