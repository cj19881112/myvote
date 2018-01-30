package com.cj.vote.repo;

import com.cj.vote.domain.Craft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CraftRepo {
    @Autowired
    private JdbcTemplate db;

    public List<Craft> findBySenseId(Long senseId) {
        return db.query("SELECT *, " +
                        "(SELECT count(0) FROM t_vote u WHERE u.craft_id = t.craft_id AND u.vote_type = '0') AS normal_vote, " +
                        "(SELECT count(0) FROM t_vote u WHERE u.craft_id = t.craft_id AND u.vote_type = '1') AS expert_vote," +
                        "(SELECT count(0) FROM t_vote u WHERE u.craft_id = t.craft_id AND u.vote_type = '2') AS super_vote  " +
                        "FROM t_craft t WHERE t.sense_id = ? ORDER BY t.sort;",
                new Object[]{senseId},
                new BeanPropertyRowMapper<Craft>(Craft.class));
    }

    public List<Craft> findBySenseId(Long senseId, String userId) {
        return db.query("SELECT *, " +
                        "(SELECT count(0) FROM t_vote u WHERE u.craft_id = t.craft_id AND u.vote_type = '0') AS normal_vote, " +
                        "(SELECT count(0) FROM t_vote u WHERE u.craft_id = t.craft_id AND u.vote_type = '1') AS expert_vote, " +
                        "(SELECT count(0) FROM t_vote u WHERE u.craft_id = t.craft_id AND u.vote_type = '2') AS super_vote, " +
                        "(SELECT count(0) FROM t_vote m WHERE m.user_id = ? AND m.sense_id = ?) > 0 AS is_voted FROM t_craft t WHERE t.sense_id = ? ORDER BY t.sort;;",
                new Object[]{userId, senseId, senseId},
                new BeanPropertyRowMapper<Craft>(Craft.class));
    }

    public Craft findById(Long id) {
        List<Craft> crafts = db.query("SELECT * FROM t_craft t WHERE t.craft_id = ?", new Object[]{id}, new BeanPropertyRowMapper<Craft>(Craft.class));
        if (crafts != null && crafts.size() > 0) {
            return crafts.get(0);
        }
        return null;
    }
}
