package com.cj.vote.utils;

public class AlreadyVoteException extends RuntimeException {
    @Override
    public String getMessage() {
        return "您已经投过票了";
    }
}
