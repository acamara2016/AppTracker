package com.example.softwareen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.softwareen.db.FirebaseHandler;
import com.example.softwareen.objects.Substance;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class add_substance_list extends AppCompatActivity {
    private EditText substance_name, substance_amount_taken;
    private Button add_substance_btn;
    private FirebaseHandler db;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_substance_list);
        substance_amount_taken = findViewById(R.id.substance_amount_taken);
        substance_name = findViewById(R.id.substance_name);
        add_substance_btn = findViewById(R.id.add_subtance_button);
        db = new FirebaseHandler("t1");
        mAuth = FirebaseAuth.getInstance();
    }
    public void addSubstance(View view){

        String amount = substance_amount_taken.getText().toString();
        String name = substance_name.getText().toString();
        Substance substance = new Substance(name,amount);
        FirebaseUser user = mAuth.getCurrentUser();
        //db.addSubstance(substance);
        Toast.makeText(add_substance_list.this, "Successfully entered your data",
                Toast.LENGTH_SHORT).show();
    }
}
