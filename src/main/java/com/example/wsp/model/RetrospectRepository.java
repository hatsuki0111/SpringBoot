package com.example.wsp.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.springframework.jdbc.core.BeanPropertyRowMapper.newInstance;

@Repository
public class RetrospectRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public int insert(Retrospect retrospect){
        var sql = "insert into retrospect values(?,?)";

        var n = jdbc.update(sql,retrospect.getText(),retrospect.getPostedAt());

        return n;
    }

    public List<Retrospect> select(){
        var sql = "select text, POSTED_AT from retrospect order by posted_at desc";

        return jdbc.query(sql,newInstance(Retrospect.class));
    }


}
