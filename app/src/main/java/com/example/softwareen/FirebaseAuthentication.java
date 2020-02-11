package com.example.softwareen;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseAuthentication {
    private FirebaseAuth mAuth;
    private DatabaseHandler database;
    public FirebaseAuthentication(){
        mAuth = FirebaseAuth.getInstance();
        database = new DatabaseHandler("t1");
    }
}
