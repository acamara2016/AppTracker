package com.example.softwareen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.regex.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText inputEmail, inputPassword, inputUsername;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private TextView password_feedback;
    public String state;
    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public EditText username, date, phone, address;
    DatabaseReference ref = database.getReference("t1");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        state = "Register";
        super.onCreate(savedInstanceState);
        if(state.equals("login")){
            setContentView(R.layout.login);
        }else if(state.equals("Register")){
            setContentView(R.layout.register);
        }
        mAuth = FirebaseAuth.getInstance();
        password_feedback=findViewById(R.id.feedback);
        password_feedback.setVisibility(View.GONE);


    }
    public void login(View view){
        inputEmail= findViewById(R.id.email);
        inputPassword= findViewById(R.id.password);

        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        login(email,password);
    }
    public void information(View view){
        username=findViewById(R.id.username);
        date=findViewById(R.id.date);
        address=findViewById(R.id.address);
        Date d=new Date();
        d.setTime(date.getDrawingTime());
        Address ad = null;
        ad.setPostalCode(address.toString());
        String user = username.getText().toString();
        registerInformation(user,d,ad);
    }

    public void loginUI(View view){
        setContentView(R.layout.login);
    }
    public void registerUI(View view){
        setContentView(R.layout.register);
    }
    public void SignUp(View view){
        inputEmail= findViewById(R.id.email);
        inputPassword= findViewById(R.id.password);
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        //validating the password
        PasswordValidoator p= new PasswordValidoator();
        Boolean pass= p.validate(password);
        if(pass==true) {
            strongPassword();
            register(email, password);
        }else{
            weakPassword();
        }

    }
    public void onStart(){
        super.onStart();
        //check if user is connected
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    public void strongPassword(){
        password_feedback.setVisibility(View.GONE);
        password_feedback.setText("Good password");
        password_feedback.setVisibility(View.VISIBLE);
        //password_feedback.setTextColor(Integer.parseInt("GREEN"));
    }
    public void weakPassword(){
        password_feedback.setVisibility(View.GONE);
        password_feedback.setText("Weak password");
        password_feedback.setVisibility(View.VISIBLE);
        //password_feedback.setTextColor(Integer.parseInt("RED"));
    }
    public void register(String email, final String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            ref = database.getReference();
                            ref.child("user").push().setValue(password);
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    public void registerInformation(String name, Date d, Address a){
        ref=database.getReference("user");
        String date = d.toString();
        String address = a.getAddressLine(a.getMaxAddressLineIndex());

        ref.setValue("Name:"+name+" Date:"+date+" Address:"+address);
    }
    public void login(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            setContentView(R.layout.activity_main2);
                            startActivity(new Intent(MainActivity.this, Main2Activity.class));
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser currentUser) {
    }
}

