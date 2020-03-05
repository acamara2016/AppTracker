package com.example.softwareen.db;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.softwareen.objects.Substance;
import com.example.softwareen.objects.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FirebaseHandler {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref;
    public FirebaseHandler(String reference) {

        ref= database.getReference(reference);
    }

    /**
     * Pass the consumed substance to user consumed substance table on Firebase
     * @param s
     * @param user
     */
    public void addCustomSubstance(Substance s, User user){

        ref.child(user.getUID()).child("Consumed_Substances").push().setValue(s);

    }

    public void addSubstance(String uid, Substance s){
        ref = database.getReference("/");
        ref.child("User").child(uid).child("Substances").setValue(s);
    }

    /**
     * Iteration 2, check firebase is username already exist
     * @param u
     */
    public boolean AddUserInfo(User u)
    {
        ref = database.getReference("/");
        if(retrieveUserData(u.getUsername())== null){
            ref.child("User").child(u.getUID()).setValue(u);
            return true;
        }
        return false;
    }

    public void retrieveSubstance(){
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public User retrieveUser(){
        final User[] u = new User[1];
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                u[0] = user;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return u[0];
    }

    public String retrieveUserData(String preferredUserName){
        ref = database.getReference("/Users/"+preferredUserName);
        final String[] userName = new String[1];
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userName[0] = (String) dataSnapshot.child("preferredUserName").getValue();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return userName[0];
    }
    public void retrieveDataByObject(String path, ArrayList<Substance> substances){
        ref = database.getReference(path);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    snap.child("preferredUserName").getValue();
                    snap.child("emailAddress").getValue();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



}
