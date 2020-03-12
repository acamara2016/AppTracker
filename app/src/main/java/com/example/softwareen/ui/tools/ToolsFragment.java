package com.example.softwareen.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.softwareen.R;
import com.example.softwareen.database.FirebaseHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private EditText first_name, username, last_name;
    public final static String UID = "userUID";
    DatabaseReference ref;
    FirebaseHandler fb = new FirebaseHandler();
    private FirebaseAuth mAuth;
    private String uid;
    private Button updateUsernameBTN, updateFirstnameBTN, updateLastnameBTN;
    private String first_nameValue, last_nameValue, usernameValue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        first_name = root.findViewById(R.id.update_firstname);
        last_name = root.findViewById(R.id.update_lastname);
        username = root.findViewById(R.id.update_username);

        updateFirstnameBTN = root.findViewById(R.id.first_name_update_button);
        updateLastnameBTN = root.findViewById(R.id.last_name_update_button);
        updateUsernameBTN = root.findViewById(R.id.username_update_btn);

        uid = user.getUid();
        ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid);
        ref.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                first_nameValue = dataSnapshot.child("first_name").getValue().toString();
                last_nameValue = dataSnapshot.child("last_name").getValue().toString();
                usernameValue= dataSnapshot.child("username").getValue().toString();

                first_name.setText(first_nameValue);
                last_name.setText(last_nameValue);
                username.setText(usernameValue);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        updateUsernameBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb.updateUsername(username.getText().toString(),uid);
            }
        });
        updateLastnameBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb.updateLastName(last_name.getText().toString(),uid);
            }
        });
        updateFirstnameBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb.updateFirstName(first_name.getText().toString(),uid);
            }
        });
        return root;
    }
}