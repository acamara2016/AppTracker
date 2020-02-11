package com.example.softwareen;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlcoholTest {

    @Test
    public void test_get_methods(){

        String id = "098kdos970";
        String name ="Scotia" ;
        double amount = 1;
        double alcohol_per_volume = 5;
        String type= "Wine";

        Alcohol testCase = new Alcohol("098kdos970", "Scotia", 1,"Wine", 5);

        assertTrue( "Set method for name is correct", id.equals(testCase.getName()));
        assertTrue( "Set method for amount is correct", amount ==testCase.getAmount());
        assertTrue( "Set method for type is correct", id.equals(testCase.getType()));
        assertTrue( "Set method for alcohol_per_volume is correct", id.equals(testCase.getType()));
    }

    @Test
    public void test_toString_methods(){

        Alcohol testCase = new Alcohol("098kdos970", "Scotia", 1,"Wine", 5);
        String testString = "Name: Scotia" + "\n" +
                "Type: Wine" + "\n" +
                "ABV: 5%";

        assertTrue( "toString method works: ", testString.equals(testCase.toString()));
    }

}