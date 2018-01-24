package com.cj.vote.service;

import com.cj.vote.domain.Craft;

import java.util.List;

public interface CraftService {
    List<Craft> findBySenseId(Long senseId);

    List<Craft> findBySenseId(Long senseId, String userId);

    Craft findById(Long craftId);
}
