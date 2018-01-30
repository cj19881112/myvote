package com.cj.vote.domain.enumeration;

public enum  EnumBoolean {
    TRUE("1"), FALSE("0");

    private String flag;
    EnumBoolean(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }
}
