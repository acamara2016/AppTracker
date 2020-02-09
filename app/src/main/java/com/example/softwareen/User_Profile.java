package com.example.softwareen;

public class User_Profile {

    private String first_Name;
    private String last_Name;
    private String email;
    private String password;

    User_Profile(){}
    User_Profile(String first_Name, String last_Name, String email, String password ){

        this.first_Name=first_Name;
        this.last_Name=first_Name;
        this.email=email;
        this.password=password;

    }

    public String get_First_Name(){return first_Name;}//getter methods for each variable
    public String get_Last_Name(){return last_Name;}
    public String get_Email(){return email;}//getter methods for each variable
    public String get_Password(){return password;}


}
