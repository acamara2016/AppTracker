package com.example.softwareen;

import android.content.Intent;
import android.os.Bundle;

import com.example.softwareen.db.FirebaseHandler;
import com.example.softwareen.objects.Substance;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.softwareen.ui.main.SectionsPagerAdapter;

public class home_screen extends AppCompatActivity {
    FirebaseHandler fb = new FirebaseHandler("/");
    TextView feedback;
    public final static String USERNAME = "PreferredUsername";
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        feedback = findViewById(R.id.feedback);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        Intent intent = getIntent();
        uid = intent.getStringExtra(home_screen.USERNAME);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fb.addSubstance(uid, new Substance("Substance 1","2"));
            }
        });

    }
    public void addSubs(View view){
        fb.addSubstance(uid, new Substance("Substance 1","2"));
    }
}