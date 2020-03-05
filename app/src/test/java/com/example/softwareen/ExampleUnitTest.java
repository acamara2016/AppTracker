package com.example.softwareen;

import com.example.softwareen.objects.User;
import com.example.softwareen.db.FirebaseHandler;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public FirebaseHandler fb = new FirebaseHandler("/");
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    //public void storeDataToFirebase() {assertTrue();}
    @Test
    public void storing_data_to_Firebase_Table_return_True() {
        FirebaseHandler fb = new FirebaseHandler("/");
        User user = new User("#1","username","first","last","email","password");
        assertTrue(fb.AddUserInfo(user));
        assertNotNull(fb.retrieveUserData(user.getUsername())!=null);

    }

}