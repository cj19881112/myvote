package com.cj.vote.domain;

public class Craft {
    private Long craftId;
    private Long voteId;
    private Long senseId;

    private String name;
    private String img;
    private String isVoted;
    private Long normalVote;
    private Long expertVote;

    public Long getCraftId() {
        return craftId;
    }

    public void setCraftId(Long craftId) {
        this.craftId = craftId;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Long getSenseId() {
        return senseId;
    }

    public void setSenseId(Long senseId) {
        this.senseId = senseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNormalVote() {
        return normalVote;
    }

    public void setNormalVote(Long normalVote) {
        this.normalVote = normalVote;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getExpertVote() {
        return expertVote;
    }

    public void setExpertVote(Long expertVote) {
        this.expertVote = expertVote;
    }

    public String getIsVoted() {
        return isVoted;
    }

    public void setIsVoted(String isVoted) {
        this.isVoted = isVoted;
    }
}
