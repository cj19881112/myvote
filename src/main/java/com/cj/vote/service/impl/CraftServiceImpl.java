package com.cj.vote.service.impl;

import com.cj.vote.domain.Craft;
import com.cj.vote.repo.CraftRepo;
import com.cj.vote.service.CraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CraftServiceImpl implements CraftService {

    @Autowired
    private CraftRepo craftRepo;

    @Override
    public List<Craft> findBySenseId(Long senseId) {
        return craftRepo.findBySenseId(senseId);
    }

    @Override
    public List<Craft> findBySenseId(Long senseId, String userId) {
        return craftRepo.findBySenseId(senseId, userId);
    }

    @Override
    public Craft findById(Long craftId) {
        return craftRepo.findById(craftId);
    }
}
