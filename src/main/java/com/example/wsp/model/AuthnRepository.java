package com.example.wsp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

import static java.lang.reflect.Array.newInstance;

@Repository
public class AuthnRepository {

    @Autowired
    private JdbcTemplate jdbc;


    public Authn select(String userId) throws NoSuchElementException {
        var sql = "select * from authn where user_id = ?";
        return jdbc.query(sql, BeanPropertyRowMapper.newInstance(Authn.class),userId)
                .stream()
                .findFirst()
                .orElseThrow();
    }

}
