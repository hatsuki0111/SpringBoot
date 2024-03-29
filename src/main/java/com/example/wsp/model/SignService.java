package com.example.wsp.model;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


/**
 *
 */
@Service
public class SignService {

    @Autowired
    private AuthnRepository repository;

    public boolean doSignIn(String userId, String passphrase) {
        var authn = repository.select(userId);
        try {
            if (DigestUtils.sha1Hex(passphrase).equals(authn.getPassphrase())) {
                return true;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Autnからデータを取得
    public Authn getAuthn(String userId){
        var authn = repository.select(userId);
        return authn;
    }
}
