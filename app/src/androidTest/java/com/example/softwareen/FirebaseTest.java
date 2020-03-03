package com.example.softwareen;

import com.example.softwareen.db.FirebaseHandler;
import com.example.softwareen.objects.Cannibus;
import com.example.softwareen.objects.User;
import com.google.firebase.auth.FirebaseAuth;

import static org.junit.Assert.assertTrue;

public class FirebaseTest {
    private FirebaseAuth mAuth;
    User u=new User();
    FirebaseHandler handler = new FirebaseHandler("t1");
    public void main(String[] args){
        u.setEmail("dummy@gmail.com");
        u.setFirst_name("FirstName");
        u.setLast_name("LastName");
        u.setUsername("acamara");

        handler.AddUserInfo(new User("hdyegfjcwe","username","first_name","last_name","email@gmail.uk","password"));


    }
    public void test_get_methods(){

        String uid = "098kdos970";
        String first_name ="Scotia" ;
        String last_name= "last_name";
        String username="username";
        String email="email@dal.uk";
        String password="password";
        double amount = 1;
        String strain = "Sativa";
        double cbd = 12;
        double thc = 22;


        Cannibus testCase = new Cannibus("098kdos970", "Scotia", "1","Sativa",12,22);
        User u =new User(uid,username,first_name,last_name,email,password);
        handler.AddUserInfo(u);
        handler.addCustomSubstance(testCase, u);

    }

}
