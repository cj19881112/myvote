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
        List<Sense> senses = db.query("SELECT *, now() c_time," +
                        "(SELECT COUNT(0) FROM t_sense u WHERE u.sort > t.sort) hasNext, " +
                        "(SELECT COUNT(0) FROM t_sense u WHERE u.sort < t.sort) hasPrev FROM " +
                        "t_sense t WHERE t.is_current = ? ORDER BY t.sort;",
                new Object[]{EnumBoolean.TRUE.getFlag()},
                new BeanPropertyRowMapper<Sense>(Sense.class));
        if (senses != null && senses.size() > 0) {
            return senses.get(0);
        }
        return null;
    }

    public Sense findById(Long senseId) {
        List<Sense> senses = db.query("SELECT *, now() c_time, " +
                        "(SELECT count(0) FROM t_sense u WHERE u.sort > t.sort) hasNext, " +
                        "(SELECT count(0) FROM t_sense u WHERE u.sort < t.sort) hasPrev FROM " +
                        "t_sense t WHERE t.sense_id = ?",
                new Object[]{senseId},
                new BeanPropertyRowMapper<Sense>(Sense.class));
        if (senses != null && senses.size() > 0) {
            return senses.get(0);
        }
        return null;
    }

    public int changeStatus(Long senseId, String status) {
        if (status.equals(EnumBoolean.TRUE.getFlag())) {
            return db.update("UPDATE t_sense t SET t.voting = ?, t.start_time = now() WHERE t.sense_id = ?",
                    new Object[]{status, senseId});
        } else {
            return db.update("UPDATE t_sense t SET t.voting = ?, t.stop_time = now() WHERE t.sense_id = ?",
                    new Object[]{status, senseId});
        }
    }

    public void setIsCurrent(Long senseId) {
        db.update("UPDATE t_sense t SET t.is_current = ?", new Object[]{EnumBoolean.FALSE.getFlag()});
        db.update("UPDATE t_sense t SET t.is_current = ? WHERE t.sense_id = ?",
                new Object[]{EnumBoolean.TRUE.getFlag(), senseId});
    }

    public List<Sense> findAll() {
        return db.query("SELECT *, now() c_time," +
                        "(SELECT count(0) FROM t_sense u WHERE u.sort > t.sort) hasNext," +
                        "(SELECT count(0) FROM t_sense u WHERE u.sort < t.sort) hasPrev FROM t_sense ORDER BY t.sort;",
                new BeanPropertyRowMapper<Sense>(Sense.class));
    }

    public Sense findBySort(Long sort) {
        List<Sense> senses = db.query("SELECT *, now() c_time, " +
                        "(SELECT count(0) FROM t_sense u WHERE u.sort > t.sort) hasNext, " +
                        "(SELECT count(0) FROM t_sense u WHERE u.sort < t.sort) hasPrev FROM " +
                        "t_sense t WHERE t.sort = ?;",
                new Object[]{sort},
                new BeanPropertyRowMapper<>(Sense.class));
        if (senses != null && senses.size() > 0) {
            return senses.get(0);
        }
        return null;
    }
}
