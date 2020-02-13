package com.example.softwareen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class welcome_screen_signup extends AppCompatActivity {
    private EditText username, first_name, last_name, email, password, confirm_passw;
    private TextView username_feedback, first_name_feedback, last_name_feedback, email_feedback, password_feedback, confirm_passw_feedback;
    private TextView passwd_not_match_feedback;
    private Button sign_button;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;
    FirebaseHandler db = new FirebaseHandler("t1");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_signup);
        mAuth = FirebaseAuth.getInstance();

        // getting all values
        username = findViewById(R.id.signup_username);
        first_name = findViewById(R.id.signup_firstname);
        last_name = findViewById(R.id.signup_lastname);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        confirm_passw = findViewById(R.id.signup_confirmpassword);
        sign_button = findViewById(R.id.signup_signup_btn);
        progressbar = findViewById(R.id.signup_progressbar);

    }


    public void register(View view)
    {
        String username, first_name, last_name, email, password, confirm_passw;
        username = this.username.getText().toString();
        first_name = this.first_name.getText().toString();
        last_name = this.last_name.getText().toString();
        email = this.email.getText().toString();
        password = this.password.getText().toString();
        confirm_passw = this.confirm_passw.getText().toString();
        registerNewUser(username, first_name, last_name, email, password,confirm_passw);
    }

    /**
     * @author Joshua & Robert
     * @param u
     * @param f
     * @param l
     * @param e
     * @param p
     * @param c
     * @return
     */
    private boolean validateInput(String u, String f, String l, String e, String p, String c)
    {
        username_feedback=findViewById(R.id.username_input_feedback);
        first_name_feedback=findViewById(R.id.first_name_input_feedback);
        last_name_feedback=findViewById(R.id.last_name_input_feedback);
        email_feedback=findViewById(R.id.signup_email);
        password_feedback=findViewById(R.id.password_input_feedback);
        confirm_passw_feedback=findViewById(R.id.confirm_input_feedback);
        passwd_not_match_feedback=findViewById(R.id.username_input_feedback);
        //change the Toast to TextView that will appear when user fail dto fill fields
        if (TextUtils.isEmpty(u)) {
            username_feedback.setVisibility(View.VISIBLE);
            return true;
        }
        if (TextUtils.isEmpty(f)) {
            first_name_feedback.setVisibility(View.VISIBLE);
            return true;
        }
        if (TextUtils.isEmpty(l)) {
            last_name_feedback.setVisibility(View.VISIBLE);
            return true;
        }
        if (TextUtils.isEmpty(e)) {
            email_feedback.setVisibility(View.VISIBLE);
            return true;
        }
        if (TextUtils.isEmpty(p)) {
            password_feedback.setVisibility(View.VISIBLE);
            return true;
        }
        if(TextUtils.isEmpty(c)){
            confirm_passw_feedback.setVisibility(View.VISIBLE);
        }
        return false;
    }
    public void registerNewUser(final String u, final String f, final String l, final String e, final String p, String c){
        if(validateInput(u,f,l,e,p,c) == true)
            return;
        else{
            mAuth.createUserWithEmailAndPassword(e, p)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {

                                FirebaseUser user = mAuth.getCurrentUser();
                                db.AddUserInfo(new User(user.getUid(),u,f,l,e,p));
                                Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(welcome_screen_signup.this, welcome_screen_login.class);
                                startActivity(intent);
                                progressbar.setVisibility(View.GONE);


                            } else
                            {

                                Toast.makeText(getApplicationContext(), "Registration failed!!" + " Please try again later", Toast.LENGTH_LONG).show();
                                progressbar.setVisibility(View.GONE);

                            }

                            // ...
                        }
                    });
        }}




}













