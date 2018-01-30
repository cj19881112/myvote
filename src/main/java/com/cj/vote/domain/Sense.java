package com.cj.vote.domain;

import java.util.Date;
import java.util.List;

public class Sense {
    private Long senseId;
    private Long showId;
    private String isCurrent;
    private String senseName;
    private String voting;
    private String hasNext;
    private String hasPrev;
    private String img;
    private Date startTime;
    private Date stopTime;
    private Date cTime;

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

    public String getHasNext() {
        return hasNext;
    }

    public void setHasNext(String hasNext) {
        this.hasNext = hasNext;
    }

    public String getHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(String hasPrev) {
        this.hasPrev = hasPrev;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
