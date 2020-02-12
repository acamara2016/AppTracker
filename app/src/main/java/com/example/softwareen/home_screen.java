package com.example.softwareen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_screen extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
//Thats is the button reference ID
        button=(Button)findViewById(R.id.addSubstance_button);
        /*This sets up the screen so that when the button is clicked, it automatically goes to the
       secondActivity which is the add_substance_list.class */
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
        Intent i=new Intent(home_screen.this,add_substance_list.class);
        startActivity(i);
    }
}
