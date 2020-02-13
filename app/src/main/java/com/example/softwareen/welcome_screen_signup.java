package com.example.softwareen;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class welcome_screen_signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen_signup);

        Button signup_signup_btn = (Button) findViewById(R.id.signup_signup_btn);
        signup_signup_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText signup_username = (EditText) findViewById(R.id.signup_username);
                EditText signup_firstname = (EditText) findViewById(R.id.signup_firstname);
                EditText signup_lastname = (EditText) findViewById(R.id.signup_lastname);
                EditText signup_email = (EditText) findViewById(R.id.signup_email);
                EditText signup_password = (EditText) findViewById(R.id.signup_password);
                EditText signup_confirm_password = (EditText) findViewById(R.id.signup_confirmpassword);


                String signup = signup_username.getText().toString();
                String last_name = signup_lastname.getText().toString();
                String first_name = signup_firstname.getText().toString();
                String email = signup_email.getText().toString();
                String password = signup_password.getText().toString();
                String confirm_password = signup_confirm_password.getText().toString();

                Boolean valid_username = name_validator(signup);
                Boolean valid_first_name = name_validator(first_name);
                Boolean valid_last_name = name_validator(last_name);
                Boolean valid_email= email_validator(email);
                Boolean valid_password= password_confirmation(password,confirm_password);

                User user_profile = new User("aaaa", signup,last_name,first_name,email,password);


                if (valid_username==true && valid_first_name ==true && valid_last_name == true
                && valid_email && valid_password ==true) {

                    signUp_home_profile(user_profile);
                }

                else{
                    sign_up_error();
                }

            }
        });
    }

    public void signUp_home_profile(User new_user) {
        //Intent intent = new Intent(this, home_screen.class);
        //startActivity(intent);

        Intent intent = new Intent(this, home_profile.class);
        intent.putExtra("Profile",new_user);
        startActivity(intent);
    }

    public void sign_up_error() {
        Intent intent = new Intent(this, temperaryErrorPage.class);
        startActivity(intent);
    }

    public static boolean name_validator(String name) {
        Boolean valid;

        if (name.length() == 0 || name.equals("") || name == null) {
            valid = false;

        } else {
            valid = true;
        }
        return valid;
    }

    public static boolean email_validator(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean password_confirmation(String password1, String password2) {

        boolean passwords_match;
        if (password1.equals(password2)){
            passwords_match = true;
        }
        else{
            passwords_match = false;
        }
        return passwords_match;
    }
}



















