package com.example.softwareen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class home_screen extends AppCompatActivity {

    private FloatingActionButton button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        //Thats is the button reference ID
        button=(FloatingActionButton)findViewById(R.id.addSubstance_button);
        /*This sets up the screen so that when the button is clicked, it automatically goes to the secondActivity which is the add_substance_list.class */
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                action();
            }

        });
    }
    public void action()
    {
        Intent intent=new Intent(this,home_screen2.class);
        startActivity(intent);
    }
}

