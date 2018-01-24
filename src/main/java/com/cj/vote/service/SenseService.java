package com.cj.vote.service;

import com.cj.vote.domain.Sense;
import com.cj.vote.utils.InvalidSenseException;

import java.util.List;

public interface SenseService {
    Sense currentSense() throws InvalidSenseException;
    Sense currentSense(String uid) throws InvalidSenseException;
    Sense findById(Long senseId);
    void stop(Long senseId) throws InvalidSenseException;
    void switchTo(Long senseId) throws InvalidSenseException;
    List<Sense> allSense();
    void start(Long senseId) throws InvalidSenseException;

    void nextSense() throws InvalidSenseException;

    void prevSense() throws InvalidSenseException;
}
