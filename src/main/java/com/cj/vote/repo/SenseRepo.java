package com.cj.vote.repo;

import com.cj.vote.domain.Sense;
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
        List<Sense> senses = db.query("select *, " +
                        "(select count(0) from t_sense u where u.sense_id > t.sense_id) hasNext, " +
                        "(select count(0) from t_sense u where u.sense_id < t.sense_id) hasPrev from " +
                        "t_sense t where t.is_current = '1'",
                new BeanPropertyRowMapper<Sense>(Sense.class));
        if (senses != null && senses.size() > 0) {
            return senses.get(0);
        }
        return null;
    }

    public Sense findById(Long senseId) {
        List<Sense> senses = db.query("select *, " +
                        "(select count(0) from t_sense u where u.sense_id > t.sense_id) hasNext, " +
                        "(select count(0) from t_sense u where u.sense_id < t.sense_id) hasPrev from " +
                        "t_sense t where t.sense_id = ?",
                new Object[]{senseId},
                new BeanPropertyRowMapper<Sense>(Sense.class));
        if (senses != null && senses.size() > 0) {
            return senses.get(0);
        }
        return null;
    }

    public int changeStatus(Long senseId, String status) {
        return db.update("update t_sense t set t.voting = ? where t.sense_id = ?",
                new Object[]{status, senseId});
    }

    public void setIsCurrent(Long senseId) {
        db.update("update t_sense t set t.is_current = '0'");
        db.update("update t_sense t set t.is_current = '1' where t.sense_id = ?",
                new Object[]{senseId});
    }

    public List<Sense> findAll() {
        return db.query("select *," +
                "(select count(0) from t_sense u where u.sense_id > t.sense_id) hasNext," +
                "(select count(0) from t_sense u where u.sense_id < t.sense_id) hasPrev from t_sense ",
                new BeanPropertyRowMapper<Sense>(Sense.class));
    }
}
