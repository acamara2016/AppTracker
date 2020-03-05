package com.example.softwareen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.*;
import android.view.*;

public class home_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_profile);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("Profile");

        TextView welcome = (TextView) findViewById(R.id.welcome);
        welcome.setText("Welcome " + user.getUsername());

    }
}
