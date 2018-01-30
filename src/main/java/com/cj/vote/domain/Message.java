package com.cj.vote.domain;

public class Message {
    public static final Message START_STOP_MSG = new Message(Message.START_STOP, null);
    public static final Message SWITCH_MSG = new Message(Message.SWITCH_SENSE, null);

    public static final String SWITCH_SENSE = "SWITCH_SENSE";
    public static final String START_STOP = "START_STOP";

    private String code;
    private Object data;

    Message(String code, Object data) {
        this.code = code;
        this.data = data;
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
