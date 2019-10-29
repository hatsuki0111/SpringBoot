package com.example.wsp.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;






@Service
public class SignService {

    @Autowired
    private AuthnRepository repository;

    public String register(String userid, String passphrase) {
        var authN = new AuthN(userid, passphrase);
        try {
            var n = repository.insert(authN);
            var message = n > 0 ? n + "件を追加" : "追加失敗";
            return message;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return "error";
    }

    //ToDo try-catch
    public boolean doSignIn(String userId, String passphrase) {
            if (repository.select(userId).equals(passphrase)) {
                return true;
            }
            return false;
        }
}
//Objects.equals( userId,repository.select()