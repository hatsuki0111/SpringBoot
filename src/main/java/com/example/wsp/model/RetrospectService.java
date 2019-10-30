package com.example.wsp.model;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.util.List;

import static java.util.Collections.emptyList;


@Service
public class RetrospectService {

    @Autowired
    private RetrospectRepository repository;

    public String register(String text){
        var retrospect = new Retrospect(text);
        try{
          var n = repository.insert(retrospect);
            var message = n>0? n+"件を追加":"追加失敗";
          return message;
        }catch (DataAccessException e) {
            e.printStackTrace();
        }
         return "error";
    }

    public List<Retrospect> findAll(){
        try{
            var test = repository.select();
            System.out.println(test);
            return test;
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return emptyList();
    }
}
