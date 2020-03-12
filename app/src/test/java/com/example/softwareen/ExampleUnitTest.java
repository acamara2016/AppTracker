package com.example.softwareen;

import com.example.softwareen.database.FirebaseHandler;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    FirebaseHandler fb = new FirebaseHandler();
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void getCurrentDate(){
        System.out.print(fb.giveDate());
    }

}