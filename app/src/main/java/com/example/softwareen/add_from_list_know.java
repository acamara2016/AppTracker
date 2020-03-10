package com.example.softwareen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.softwareen.db.FirebaseHandler;
import com.example.softwareen.objects.Substance;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;

public class add_from_list_know extends AppCompatActivity {

    FirebaseHandler fb = new FirebaseHandler();
    private FirebaseAuth mAuth;
    private Button add_custom;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_create_substance);

        final List<Substance> dummyList = new ArrayList<Substance>();
        dummyList.add(new Substance("1","Beer",2));
        dummyList.add(new Substance("1","Whiskey",2));
        dummyList.add(new Substance("1","Rhum",2));
        dummyList.add(new Substance("1","Wine",2));
        dummyList.add(new Substance("1","Water",2));

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        final String uid = user.getUid();
        listView = findViewById(R.id.pre_made_list_view);
        add_custom = findViewById(R.id.button_add_new_custom);
        ArrayAdapter<Substance> adapter = new ArrayAdapter<Substance>(
                this,
                android.R.layout.simple_list_item_1,
                dummyList
        );
        listView.setAdapter(adapter);

        /**
         * When user click on an item of the listView
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                fb.AddingSubstance(uid,dummyList.get(position));
                Toast.makeText(add_from_list_know.this, "Successfully recorded "+dummyList.get(position)+"Return & Refresh to see list", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * onClick handle the request user to record a consumed substance
         */
        add_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_from_list_know.this, add_create_substance.class);
                startActivity(intent);
            }
        });

    }

}
