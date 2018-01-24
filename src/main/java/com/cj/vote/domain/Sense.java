package com.cj.vote.domain;

import java.util.List;

public class Sense {
    private Long senseId;
    private Long showId;
    private String isCurrent;
    private String senseName;
    private String voting;

    private List<Craft> craftList;

    public Long getSenseId() {
        return senseId;
    }

    public void setSenseId(Long senseId) {
        this.senseId = senseId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(String isCurrent) {
        this.isCurrent = isCurrent;
    }

    public String getSenseName() {
        return senseName;
    }

    public void setSenseName(String senseName) {
        this.senseName = senseName;
    }

    public String getVoting() {
        return voting;
    }

    public void setVoting(String voting) {
        this.voting = voting;
    }

    public List<Craft> getCraftList() {
        return craftList;
    }

    public void setCraftList(List<Craft> craftList) {
        this.craftList = craftList;
    }
}
