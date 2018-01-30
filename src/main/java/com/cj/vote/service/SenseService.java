package com.cj.vote.service;

import com.cj.vote.domain.Sense;

import java.util.List;

public interface SenseService {
    Sense currentSense();

    Sense currentSense(String uid);

    Sense findById(Long senseId);

    void stop(Long senseId);

    void switchTo(Long senseId);

    void start(Long senseId);

    void nextSense();

    void prevSense();
}
