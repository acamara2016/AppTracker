package com.example.softwareen;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddSubtanceTest {

    @Test
    public void addSubstanceTest(){
        User a = new User("a","b","c","d","e","f");
        Substance vodka = new Alcohol("a","b",100,"d",4.5);

        a.addSubstance(vodka);

        assertTrue("Substance added properly to user", a.getDiary().contains(vodka));
    }


}
