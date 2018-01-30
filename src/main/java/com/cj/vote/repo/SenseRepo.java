package com.cj.vote.repo;

import com.cj.vote.domain.Sense;
import com.cj.vote.domain.enumeration.EnumBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SenseRepo {
    @Autowired
    private JdbcTemplate db;

    public Sense currentSense() {
        List<Sense> senses = db.query("SELECT *, " +
                        "(SELECT count(0) FROM t_sense u WHERE u.sense_id > t.sense_id) hasNext, " +
                        "(SELECT count(0) FROM t_sense u WHERE u.sense_id < t.sense_id) hasPrev FROM " +
                        "t_sense t WHERE t.is_current = ?",
                new Object[]{EnumBoolean.TRUE.getFlag()},
                new BeanPropertyRowMapper<Sense>(Sense.class));
        if (senses != null && senses.size() > 0) {
            return senses.get(0);
        }
        return null;
    }

    public Sense findById(Long senseId) {
        List<Sense> senses = db.query("SELECT *, " +
                        "(SELECT count(0) FROM t_sense u WHERE u.sense_id > t.sense_id) hasNext, " +
                        "(SELECT count(0) FROM t_sense u WHERE u.sense_id < t.sense_id) hasPrev FROM " +
                        "t_sense t WHERE t.sense_id = ?",
                new Object[]{senseId},
                new BeanPropertyRowMapper<Sense>(Sense.class));
        if (senses != null && senses.size() > 0) {
            return senses.get(0);
        }
        return null;
    }

    public int changeStatus(Long senseId, String status) {
        return db.update("UPDATE t_sense t SET t.voting = ? WHERE t.sense_id = ?",
                new Object[]{status, senseId});
    }

    public void setIsCurrent(Long senseId) {
        db.update("UPDATE t_sense t SET t.is_current = ?", new Object[]{EnumBoolean.FALSE.getFlag()});
        db.update("UPDATE t_sense t SET t.is_current = ? WHERE t.sense_id = ?",
                new Object[]{EnumBoolean.TRUE.getFlag(), senseId});
    }

    public List<Sense> findAll() {
        return db.query("SELECT *," +
                        "(SELECT count(0) FROM t_sense u WHERE u.sense_id > t.sense_id) hasNext," +
                        "(SELECT count(0) FROM t_sense u WHERE u.sense_id < t.sense_id) hasPrev FROM t_sense ",
                new BeanPropertyRowMapper<Sense>(Sense.class));
    }
}
