package com.example.softwareen;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseTest {
    private FirebaseAuth mAuth;
    User u=new User();
    DatabaseHandler handler = new DatabaseHandler("t1");
    public void main(String[] args){
        u.setEmail("dummy@gmail.com");
        u.setFirst_name("FirstName");
        u.setLast_name("LastName");
        u.setUsername("acamara");

        handler.AddUserInfo(u,"Uihfirggh94grhf");

    }

}
