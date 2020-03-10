package com.example.softwareen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.softwareen.db.FirebaseHandler;
import com.example.softwareen.objects.Substance;
import com.example.softwareen.registration.welcome_screen_login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class add_create_substance extends AppCompatActivity {
    public final static String UID = "userUID";
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseHandler fb = new FirebaseHandler();
    private FirebaseAuth mAuth;
    private EditText subsNameView;
    private Button add_button;
    private EditText unitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_substance_list);
        subsNameView = findViewById(R.id.substance_name);
        add_button = findViewById(R.id.add_subtance_button);
        unitView = findViewById(R.id.substance_amount_taken);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        final String uid = user.getUid();
        /*listView = findViewById(R.id.pre_made_list_view);
        List<Substance> subsList = fb.retrieveConsumedSubtance();
        ArrayAdapter<Substance> adapter = new ArrayAdapter<Substance>(
                this,
                android.R.layout.simple_list_item_1,
                subsList
        );
        listView.setAdapter(adapter);
        */
        /**
         * onClick handle the request user to record a consumed substance
         */
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Substance s = new Substance();
                s.setName(subsNameView.getText().toString());
                s.setAmount(Double.parseDouble(unitView.getText().toString()));
                fb.AddingSubstance(uid,s);
            }
        });
    }
}
