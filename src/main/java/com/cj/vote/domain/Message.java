package com.cj.vote.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.springframework.stereotype.Component;

public class Message {
    private static final Gson gson = new GsonBuilder().create();
    public static final String SWITCH_SENSE = "SWITCH_SENSE";
    public static final String START_STOP = "START_STOP";
    public static final String VOTE = "VOTE";

    private String code;
    private Object data;

    Message(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static Message switchSense(Sense sense) {
        Message msg = new Message(SWITCH_SENSE, sense);
        return msg;
    }

    public static Message startStop(Sense sense) {
        Message msg = new Message(START_STOP, sense);
        return msg;
    }

    public static Message vote(Sense sense) {
        Message msg = new Message(VOTE, sense);
        return msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
