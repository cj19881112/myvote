package com.cj.vote.domain;

public class Vote {
    private Long userVoteId;
    private Long senseId;
    private Long craftId;
    private String userId;
    private String voteType;

    public Vote() {
    }

    public Vote(Long senseId, Long craftId, String uid, String voteType) {
        this.senseId = senseId;
        this.craftId = craftId;
        this.userId = uid;
        this.voteType = voteType;
    }

    public Long getUserVoteId() {
        return userVoteId;
    }

    public void setUserVoteId(Long userVoteId) {
        this.userVoteId = userVoteId;
    }

    public Long getCraftId() {
        return craftId;
    }

    public void setCraftId(Long craftId) {
        this.craftId = craftId;
    }


    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getSenseId() {
        return senseId;
    }

    public void setSenseId(Long senseId) {
        this.senseId = senseId;
    }
}
