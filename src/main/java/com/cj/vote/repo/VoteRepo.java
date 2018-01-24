package com.cj.vote.repo;

import com.cj.vote.domain.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VoteRepo {
    @Autowired
    private JdbcTemplate db;

    public void save(Vote vote) {
        db.update("insert into t_vote (`craft_id`, `user_id`, `vote_type`) values (?, ?, ?)",
                vote.getCraftId(), vote.getUserId(), vote.getVoteType());
    }

    public int countByUserId (String uid) {
        return db.queryForObject("select count(0) from t_vote t where t.user_id = ? ",
                new Object[]{uid}, Integer.class);
    }
}
