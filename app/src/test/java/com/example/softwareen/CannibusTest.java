package com.example.softwareen;

import com.example.softwareen.classes.Cannibus;

import org.junit.Test;

import static org.junit.Assert.*;

public class CannibusTest {

    @Test
    public void test_get_methods(){

        String id = "098kdos970";
        String name ="Scotia" ;
        double amount = 1;
        String strain = "Sativa";
        double cbd = 22;
        double thc = 12;

        Cannibus testCase = new Cannibus("098kdos970", "Scotia", 1,"Sativa",12,22);

        assertTrue( "Set method for name is correct", name.equals(testCase.getName()));
        assertTrue( "Set method for amount is correct", amount ==testCase.getAmount());
        assertTrue( "Set method for stain is correct", strain.equals(testCase.getType()));
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
    @Test
    public void test_validation_method(){

        Cannibus valid_cannabus= new Cannibus("1","Pinot Noir",1, "Wine",1.5, 1.5 );

        Cannibus invalid_name= new Cannibus("1","",1, "Wine",1.5, 1.5 );
        Cannibus invalid_name_null= new Cannibus("1",null,1, "Wine",1.5,1.5 );

        Cannibus invalid_amount= new Cannibus("1","Pinot Noir",-1, "Wine",1.5,1.5 );
        Cannibus invalid_amount_zero= new Cannibus("1","Pinot Noir",0, "Wine",1.5,1.5 );

        Cannibus invalid_THC= new Cannibus("1","Pinot Noir",1, "Wine",-1,1.5 );
        Cannibus invalid_THC_zero= new Cannibus("1","Pinot Noir",1, "Wine",0,1.5 );

        Cannibus invalid_CBD= new Cannibus("1","Pinot Noir",1, "Wine",1,-1 );
        Cannibus invalid_CBD_zero= new Cannibus("1","Pinot Noir",1, "Wine",1,0 );

        Cannibus invalid_strain= new Cannibus("1","Pinot Noir",1, "",1,1.5 );
        Cannibus invalid_strain_null= new Cannibus("1","Pinot Noir",1, null,1 ,1.5);

        assertTrue("The substance is valid",valid_cannabus.valid_substance(valid_cannabus));
        assertFalse("The empty name is invalid",invalid_name.valid_substance(invalid_name));
        assertFalse("The null name is invalid", invalid_name_null.valid_substance(invalid_name_null));

        assertFalse("Amount cannot be less than 0",invalid_amount.valid_substance(invalid_amount));
        assertFalse("Amount cannot be zero",invalid_amount_zero.valid_substance(invalid_amount_zero));

        assertFalse("THC cannot be less than 0",invalid_THC.valid_substance(invalid_THC));
        assertFalse("THC cannot be zero",invalid_THC_zero.valid_substance(invalid_THC_zero));

        assertFalse("CBD cannot be less than 0",invalid_CBD.valid_substance(invalid_CBD));
        assertFalse("CBD cannot be zero",invalid_CBD_zero.valid_substance(invalid_CBD_zero));

        assertFalse("The empty strain is invalid",invalid_strain.valid_substance(invalid_strain));
    }

}