package com.example.wsp.model;

public class AuthN {

    private String userid;
    private String passphrase;
    private String userName;
    private String userRole;

    public AuthN(String userid,String passphrase){
        this.userid =userid;
        this.passphrase = passphrase;
        this.userName = userName;
        this.userRole = userRole;
    }

    public AuthN(){
        this.userid ="";
        this.passphrase = "";
        this.userName = userName;
        this.userRole = userRole;
    }

    public String getUserid(){
        return userid;
    }

    public void setUserid(String userid){
        this.userid = userid;
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

    public void setUserRole(){
        this.userRole = userRole;
    }
}
