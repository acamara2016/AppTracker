package com.example.softwareen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class welcome_screen_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_login);
    }

    //Called when user clicks sign-up
    public void goToSignup(View view){
        Intent intent = new Intent(this, welcome_screen_signup.class);
        startActivity(intent);
    }

    //called when user click login
    public void login(View view){
        Intent intent = new Intent(this, home_screen.class);
        startActivity(intent);
    }

}
