package com.example.softwareen;

import org.junit.Test;

import static org.junit.Assert.*;

public class CannibusTest {

    @Test
    public void test_get_methods(){

        String id = "098kdos970";
        String name ="Scotia" ;
        double amount = 1;
        String strain = "Sativa";
        double cbd = 12;
        double thc = 22;

        Cannibus testCase = new Cannibus("098kdos970", "Scotia", 1,"Sativa",12,22);

        assertTrue( "Set method for name is correct", id.equals(testCase.getName()));
        assertTrue( "Set method for amount is correct", amount ==testCase.getAmount());
        assertTrue( "Set method for strain is correct", strain.equalsIgnoreCase(testCase.getStrain()));
        assertTrue( "Set method for thc_content is correct",thc == testCase.get_thc_content());
        assertTrue( "Set method for cbd_content is correct",cbd == testCase.get_cbd_content());

    }
    @Test
    public void test_toString_methods(){

        Cannibus testCase = new Cannibus("098kdos970", "Scotia", 1,"Sativa",12,22);
        String testString = "Name Scotia" + "\n" +
                            "Strain: Sativa" + "\n" +
                            "CBD Content: 12%" + "\n" +
                            "THC Content: 22%";

        assertTrue( "toString method works: ", testString.equals(testCase.toString()));
    }
}