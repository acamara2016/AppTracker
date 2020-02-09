package com.example.softwareen;

public class User {
    private String uid;
    private String username;
    private String first_name;
    private String last_name;
    private String email;

    public User(){

    }
    public User(String uid, String username, String first_name, String last_name, String email){
        this.email=email;
        this.username=username;
        this.first_name=first_name;
        this.last_name=last_name;
        this.uid=uid;
    }
    //setters
    public void setUID(String uid){
        this.uid=uid;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setFirst_name(String first_name){
        this.first_name=first_name;
    }
    public void setLast_name(String last_name){
        this.last_name=last_name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    //getters
    public String getUID(){return uid;}
    public String getUsername() {return username;}
    public String getFirst_name(){return first_name;}
    public String getLast_name(){return last_name;}
    public String getEmail(){return email;}

}
