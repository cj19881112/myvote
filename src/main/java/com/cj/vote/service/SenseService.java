package com.cj.vote.service;

import com.cj.vote.domain.Sense;
import com.cj.vote.utils.InvalidSenseException;

import java.util.List;

public interface SenseService {
    Sense currentSense(String uid) throws InvalidSenseException;
    Sense findById(Long senseId);
    void stop(Long senseId) throws InvalidSenseException;
    void switchTo(Long senseId) throws InvalidSenseException;
    List<Sense> allSense();
}
