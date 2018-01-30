package com.cj.vote.service.impl;

import com.cj.vote.domain.Message;
import com.cj.vote.domain.Sense;
import com.cj.vote.domain.enumeration.EnumBoolean;
import com.cj.vote.repo.SenseRepo;
import com.cj.vote.service.CraftService;
import com.cj.vote.service.SenseService;
import com.cj.vote.utils.InvalidSenseException;
import com.cj.vote.web.MsgCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SenseServiceImpl implements SenseService {
    @Autowired
    private SenseRepo senseRepo;

    @Autowired
    private CraftService craftService;

    @Autowired
    private MsgCenter msgCenter;

    @Override
    public Sense currentSense(String uid) {
        Sense sense = senseRepo.currentSense();
        if (null == sense) {
            throw new InvalidSenseException();
        }
        sense.setCraftList(craftService.findBySenseId(sense.getSenseId(), uid));
        return sense;
    }

    @Override
    public Sense currentSense() {
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
    @Transactional
    public void stop(Long senseId) {
        Sense sense = senseRepo.currentSense();
        if (null == sense) {
            throw new InvalidSenseException();
        }
        senseRepo.changeStatus(senseId, EnumBoolean.FALSE.getFlag());
        msgCenter.broadCast(Message.START_STOP_MSG);
    }


    @Override
    @Transactional
    public void start(Long senseId) {
        Sense sense = senseRepo.currentSense();
        if (null == sense) {
            throw new InvalidSenseException();
        }
        senseRepo.changeStatus(senseId, EnumBoolean.TRUE.getFlag());
        msgCenter.broadCast(Message.START_STOP_MSG);
    }

    @Override
    @Transactional
    public void nextSense() {
        switchTo(currentSense().getSenseId() + 1);
    }

    @Override
    @Transactional
    public void prevSense() {
        switchTo(currentSense().getSenseId() - 1);
    }

    @Override
    @Transactional
    public void switchTo(Long senseId) {
        Sense s = findById(senseId);
        if (null == s) {
            throw new InvalidSenseException();
        }
        senseRepo.setIsCurrent(senseId);
        msgCenter.broadCast(Message.SWITCH_MSG);
    }
}
