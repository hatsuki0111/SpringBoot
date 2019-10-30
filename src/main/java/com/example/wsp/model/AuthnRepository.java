package com.example.wsp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.lang.reflect.Array.newInstance;

@Repository
public class AuthnRepository {

    @Autowired
    private JdbcTemplate jdbc;


    public int insert(AuthN authN){
        var sql = "insert into authN values(?, ?)";
        var n = jdbc.update(sql,authN.getUserid(), authN.getPassphrase());
        return n;

    }

    public AuthN select(String userId) {
        var sql = "select user_id,passph,user_name,user_role from authen where user_id = ?";
        return jdbc.queryForObject(sql,BeanPropertyRowMapper.newInstance(AuthN.class), userId);
    }
}
