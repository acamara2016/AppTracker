package com.example.softwareen.db;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.softwareen.home_screen;
import com.example.softwareen.objects.Substance;
import com.example.softwareen.objects.User;
import com.example.softwareen.registration.welcome_screen_login;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FirebaseHandler {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    ;
    FirebaseUser user = mAuth.getCurrentUser();

    public FirebaseHandler() { }

    public String retrieveCurrentUID(){
        return user.getUid();
    }

    public void addCustomSubstance(Substance s, User user){

        ref.child(user.getUID()).child("Substances").push().setValue(s);

    }

    public void AddUserInfo(User u)
    {

        ref.child("user").child(u.getUID()).setValue(u);

    }
    public void AddDefaultSubstance(String uid){
        ref.child("user").child(uid).child("consumedList").child(giveDate()).push().setValue(new Substance(null,null,0.00));
    }
    public void AddSubstance(String uid, Substance s){
        ref.child("user").child(uid).child("consumedList").child(giveDate()).push().setValue(s);
    }
    public void updateUsername(String username, String uid){
        ref.child("user").child(uid).child("username");
    }
    public void updateFirstName(String username, String uid){
        ref.child("user").child(uid).child("first_name");
    }
    public void updateLastName(String username, String uid){
        ref.child("user").child(uid).child("last_name");
    }
    public void updateEmail(String username, String uid){
        ref.child("user").child(uid).child("email");
    }
    public String giveDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(cal.getTime());
    }
    public List<Substance> retrieveConsumedSubstance(String uid, int day){
        final List<Substance> list = new ArrayList<Substance>();
        ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid).child("consumedList").child("2020").child("03").child(String.valueOf(day));
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){
                    Substance s = new Substance();
                    s.setName((String) datasnapshot.child("name").getValue());
                    s.setAmount((Double) datasnapshot.child("name").getValue());
                    list.add(s);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return list;
    }







    public void removeCollection(String path){

    }

}
