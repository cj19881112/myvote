package com.cj.vote.service.impl;

import com.cj.vote.domain.Sense;
import com.cj.vote.repo.SenseRepo;
import com.cj.vote.service.CraftService;
import com.cj.vote.service.SenseService;
import com.cj.vote.utils.InvalidSenseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenseServiceImpl implements SenseService {
    @Autowired
    private SenseRepo senseRepo;

    @Autowired
    private CraftService craftService;

    @Override
    public Sense currentSense(String uid) throws InvalidSenseException {
        Sense sense = senseRepo.currentSense();
        if (null == sense) {
            throw new InvalidSenseException();
        }
        sense.setCraftList(craftService.findBySenseId(sense.getSenseId(), uid));
        return sense;
    }

    @Override
    public Sense currentSense() throws InvalidSenseException {
        Sense sense = senseRepo.currentSense();
        if (null == sense) {
            throw new InvalidSenseException();
        }
        sense.setCraftList(craftService.findBySenseId(sense.getSenseId()));
        return sense;
    }

    @Override
    public Sense findById(Long senseId) {
        return senseRepo.findById(senseId);
    }

    @Override
    public void stop(Long senseId) throws InvalidSenseException {
        Sense sense = senseRepo.currentSense();
        if (null == sense) {
            throw new InvalidSenseException();
        }
        senseRepo.changeStatus(senseId, "0");
    }


    @Override
    public void start(Long senseId) throws InvalidSenseException {
        Sense sense = senseRepo.currentSense();
        if (null == sense) {
            throw new InvalidSenseException();
        }
        senseRepo.changeStatus(senseId, "1");
    }

    @Override
    public void nextSense() throws InvalidSenseException {
        switchTo(currentSense().getSenseId()+1);
    }

    @Override
    public void prevSense() throws InvalidSenseException {
        switchTo(currentSense().getSenseId()-1);
    }

    @Override
    public void switchTo(Long senseId) throws InvalidSenseException {
        Sense s = findById(senseId);
        if (null == s) {
            throw new InvalidSenseException();
        }
        senseRepo.setIsCurrent(senseId);
    }

    @Override
    public List<Sense> allSense() {
        return senseRepo.findAll();
    }

}
