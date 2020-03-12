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
import android.widget.Toast;

import com.example.softwareen.db.FirebaseHandler;
import com.example.softwareen.objects.Substance;
import com.example.softwareen.registration.welcome_screen_login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class add_create_substance extends AppCompatActivity {

    //Extra Messages to pass new substance to the list
    public static final String Extra_Name = "com.example.softwareen.Extra_Name";
    public static final String Extra_Amnt = "com.example.softwareen.Extra_Amnt";

    public final static String UID = "userUID";
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

        /**
         * onClick handle the request user to record a consumed substance
         */
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Substance s = new Substance();
                s.setName(subsNameView.getText().toString());
                String Name = subsNameView.getText().toString();
                s.setAmount(Double.parseDouble(unitView.getText().toString()));
                String Amnt = unitView.getText().toString();
                //fb.AddingCustomSubstance(uid,s);
                //Toast.makeText(add_create_substance.this, "Successfully recorded "+s.getName()+"Return & Refresh to see list", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(add_create_substance.this, add_from_list_know.class);
                intent.putExtra(Extra_Name,Name);
                intent.putExtra(Extra_Amnt,Amnt);
                startActivity(intent);
            }
        });
    }
}
