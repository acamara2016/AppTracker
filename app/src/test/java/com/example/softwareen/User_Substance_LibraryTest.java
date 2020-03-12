package com.example.softwareen;

import com.example.softwareen.classes.Alcohol;

import org.junit.Test;

import static org.junit.Assert.*;

public class User_Substance_LibraryTest {

    @Test
    public void test_add_method(){

    }
    @Test
    public void test_add_method_empty_substance(){

    }
    @Test
    public void test_add_method_duplicate_substance(){

    }
    @Test
    public void test_search_method_substance_found(){

    }
    @Test
    public void test_search_method_substance_not_found(){

    }
    @Test
    public void test_view_library_with_substances(){

    }
    @Test
    public void test_view_library_without_substances(){

    }
    @Test
    public void test_validation_method(){

        User_Substance_Library substance_list = new User_Substance_Library();
        Alcohol valid_alcohol= new Alcohol("1","Pinot Noir",1, "Wine",1.5 );

        boolean test_boolean = valid_alcohol.valid_substance(valid_alcohol);
        assertTrue("The substance is valid", test_boolean);
    }
}