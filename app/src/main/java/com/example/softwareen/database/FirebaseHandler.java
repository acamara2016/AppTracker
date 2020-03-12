package com.example.softwareen.database;


import androidx.annotation.NonNull;

import com.example.softwareen.classes.Substance;
import com.example.softwareen.classes.User;
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
import java.util.List;

public class FirebaseHandler{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public String noOfConsumedSubs;
    FirebaseUser user = mAuth.getCurrentUser();
    //public String uid = user.getUid();

    public FirebaseHandler() {
        noOfConsumedSubs = "";
    }

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

    public void AddingSubstance(final String uid, final Substance s){
        ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid).child("consumedList");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long value = (Long)dataSnapshot.child("No").getValue();
                ref.child("No").setValue(value+1);
                Long index = value+1;
                ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid).child("consumedList");
                ref.child(giveDate()).child(""+index).setValue(s);
                ref.removeEventListener(this);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void AddingCustomSubstance(final String uid, final Substance s){
        ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid).child("customList");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long value = (Long)dataSnapshot.child("No").getValue();
                ref.child("No").setValue(value+1);
                Long index = value+1;
                ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid).child("customList");
                ref.child(giveDate()).child(""+index).setValue(s);
                ref.removeEventListener(this);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void AddDefaultSubstance(String uid){
        ref.child("user").child(uid).child("consumedList").child("No").setValue(0);
        ref.child("user").child(uid).child("customList").child("No").setValue(0); //Initialize custom substance table
        //ref.child("user").child(uid).child("consumedList").child(giveDate()).child(String.valueOf(1)).setValue(new Substance(null,null,0.00));
    }

    public void AddSubstance(String uid, Substance s, Long index){
        ref.child("user").child(uid).child("consumedList").child(giveDate()).child(String.valueOf(index)).setValue(s);
    }
    public void updateUsername(String username, String uid){
        ref.child("user").child(uid).child("username").setValue(username);
    }
    public void updateFirstName(String firstName, String uid){
        ref.child("user").child(uid).child("first_name").setValue(firstName);
    }
    public void updateLastName(String lastName, String uid){
        ref.child("user").child(uid).child("last_name").setValue(lastName);
    }
    public void updateEmail(String username, String uid){
        ref.child("user").child(uid).child("email");
    }


    public String giveDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(cal.getTime());
    }
    public String giveYear() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(cal.getTime());
    }
    public String giveMonth() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(cal.getTime());
    }
    public String giveDay() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        return sdf.format(cal.getTime());
    }


    public List<Substance> retrieveConsumedSubtance() {
        String uid = user.getUid();
        ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid).child("consumedList").child(giveDate());
        final List<Substance> subslist = new ArrayList<Substance>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                    Substance s = new Substance();
                    s.setName((String) userSnapshot.child("name").getValue());
                    s.setAmount((Long) userSnapshot.child("amount").getValue());
                    System.out.println(s.toString());
                    subslist.add(s);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return subslist;
    }

    public List<Substance> retrieveCustomSubstance() {
        String uid = user.getUid();
        ref = FirebaseDatabase.getInstance().getReference().child("user").child(uid).child("customList").child(giveDate());
        final ArrayList<Substance> list =  new ArrayList<Substance>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                    Substance s = new Substance();
                    s.setName((String) userSnapshot.child("name").getValue());
                    s.setAmount((Long) userSnapshot.child("amount").getValue());
                    list.add(s);
                    System.out.println(list.toString() + " "+"Array Size: "+list.size());
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
