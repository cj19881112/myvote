package com.cj.vote.service.impl;

import com.cj.vote.domain.Craft;
import com.cj.vote.domain.Sense;
import com.cj.vote.domain.Vote;
import com.cj.vote.domain.enumeration.EnumBoolean;
import com.cj.vote.repo.VoteRepo;
import com.cj.vote.service.CraftService;
import com.cj.vote.service.SenseService;
import com.cj.vote.service.VoteService;
import com.cj.vote.utils.AlreadyVoteException;
import com.cj.vote.utils.InvalidCraftException;
import com.cj.vote.utils.InvalidSenseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteRepo voteRepo;

    @Autowired
    private SenseService senseService;

    @Autowired
    private CraftService craftService;

    @Override
    public void vote(Long craftId, String uid, String voteType) {

        Craft craft = craftService.findById(craftId);
        if (null == craft) {
            throw new InvalidCraftException();
        }

        Sense sense = senseService.findById(craft.getSenseId());
        if (voteRepo.countByUserId(sense.getSenseId(), uid) > 0) {
            throw new AlreadyVoteException();
        }

        if (null == sense || !EnumBoolean.TRUE.getFlag().equals(sense.getVoting())
                || !EnumBoolean.TRUE.getFlag().equals(sense.getIsCurrent())) {
            throw new InvalidSenseException();
        }

        voteRepo.save(new Vote(sense.getSenseId(), craftId, uid, voteType));
    }
}
