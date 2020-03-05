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

    @Test
    public void test_validation_method(){

        Alcohol valid_alcohol= new Alcohol("1","Pinot Noir",1, "Wine",1.5 );
        Alcohol invalid_name= new Alcohol("1","",1, "Wine",1.5 );
        Alcohol invalid_name_null= new Alcohol("1",null,1, "Wine",1.5 );
        Alcohol invalid_amount= new Alcohol("1","Pinot Noir",-1, "Wine",1.5 );
        Alcohol invalid_amount_zero= new Alcohol("1","Pinot Noir",0, "Wine",1.5 );
        Alcohol invalid_ABV= new Alcohol("1","Pinot Noir",1, "Wine",-1 );
        Alcohol invalid_ABV_zero= new Alcohol("1","Pinot Noir",1, "Wine",0 );
        Alcohol invalid_type= new Alcohol("1","Pinot Noir",1, "",1 );
        Alcohol invalid_type_null= new Alcohol("1","Pinot Noir",1, null,1 );

        assertTrue("The substance is valid",valid_alcohol.valid_substance(valid_alcohol));
        assertFalse("The empty name is invalid",invalid_name.valid_substance(invalid_name));
        assertFalse("The null name is invalid",invalid_name_null.valid_substance(invalid_name_null));
        assertFalse("Amount cannot be less than 0",invalid_amount.valid_substance(invalid_amount));
        assertFalse("Amount cannot be zero",invalid_amount_zero.valid_substance(invalid_amount_zero));
        assertFalse("ABV cannot be less than 0",invalid_ABV.valid_substance(invalid_ABV));
        assertFalse("ABV cannot be zero",invalid_ABV_zero.valid_substance(invalid_ABV_zero));
        assertFalse("The empty type is invalid",invalid_type.valid_substance(invalid_type));
    }
}