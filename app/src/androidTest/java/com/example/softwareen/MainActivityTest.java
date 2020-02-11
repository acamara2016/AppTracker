package com.example.softwareen;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.Rule;

import org.junit.runner.RunWith;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    /* USER STORY 1 TESTS */

    @Test
    public void sign_up_empty_email_feild() {


    }

    @Test
    public void sign_up_empty_password_feild() {


    }

    @Test
    public void sign_up_invalid_email() {


    }

    @Test
    public void sign_up_invalid_password() {


    }

    @Test
    public void correct_sign_up_input_name_and_email() {

    }

    /* USER STORY 2 TESTS */

    @Test
    public void sign_in_email_incorrect() {

    }

    @Test
    public void sign_in_name_incorrect() {


    }

    @Test
    public void sign_in_empty_email_feild() {


    }

    @Test
    public void sign_in_empty_name_feild() {


    }

    @Test
    public void correct_sign_in_input_name_and_email() {}


}