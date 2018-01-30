package com.cj.vote.service;

import com.cj.vote.domain.Sense;
import com.cj.vote.utils.AlreadyVoteException;
import com.cj.vote.utils.InvalidCraftException;
import com.cj.vote.utils.InvalidSenseException;

import java.util.List;

public interface VoteService {
    void vote(Long craftId, String uid, String voteType);
}
