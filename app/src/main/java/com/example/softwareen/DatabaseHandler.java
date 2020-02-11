package com.example.softwareen;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseHandler {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref;
    public DatabaseHandler(String reference){
        ref= database.getReference(reference);
    }

    public void retrieveSubstance(){

    }
    public void addCustomSubstance(Substance s){
        ref.child("Substances").push().setValue(s);
    }
    public void retrieveSubstance(User user){

    }
    public void AddUserInfo(User u, String uid){
        ref.child("user").child(uid).setValue(u);
    }
    public void AddTakenSubstance(User u, String uid, Substance s){
        ref.child("user").child(uid).child("Consumed subtances").setValue(s);
    }
    public User retrieveUser(String uid){

        return null;
    }

}
