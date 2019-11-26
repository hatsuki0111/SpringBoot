package com.example.wsp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Authn{
    
    private String userId;
    private String passphrase;
    private String userName;
    private String userRole;


    public Authn(){
        this.userId = "";
        this.passphrase = null;
        this.userName = "";
        this.userRole = "";
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getPassphrase(){
        return passphrase;
    }

    public void setPassphrase(String passphrase){
        this.passphrase = passphrase;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserRole(){
        return userRole;
    }

    public void setUserRole(String userRole){
        this.userRole = userRole;
    }

}
