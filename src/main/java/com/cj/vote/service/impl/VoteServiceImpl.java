package com.cj.vote.service.impl;

import com.cj.vote.domain.Craft;
import com.cj.vote.domain.Sense;
import com.cj.vote.domain.Vote;
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
    public void vote(Long craftId, String uid, String voteType)
            throws InvalidCraftException, InvalidSenseException, AlreadyVoteException {
        if (voteRepo.countByUserId(uid) > 0) {
            throw new AlreadyVoteException();
        }

        Craft craft = craftService.findById(craftId);
        if (null == craft) {
            throw new InvalidCraftException();
        }

        Sense sense = senseService.findById(craft.getSenseId());
        if (null != sense && sense.getVoting().equals("1") && sense.getIsCurrent().equals("1")) {
            voteRepo.save(new Vote(craftId, uid, voteType));
        } else {
            throw new InvalidSenseException();
        }
    }
}
