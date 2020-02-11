package com.example.softwareen;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class welcome_screen_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_signup);
    }

    //used when someone clicks the signup button
    public void signUp(View view){
        Intent intent = new Intent(this, home_screen.class);
        startActivity(intent);
    }

}
