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
import static androidx.test.espresso.action.ViewActions.swipeUp;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)

public class espresso_test {

    @Rule
    public ActivityScenarioRule<welcome_screen_login> activityScenarioRule
            = new ActivityScenarioRule<>(welcome_screen_login.class);

    /* USER STORY 1 TESTS */
/*
    @Test
    public void sign_in_empty_email_feild() {

        onView(withId(R.id.login_username))
                .perform(replaceText(""));
        onView(withId(R.id.login_password))
                .perform(replaceText("Avrq17123"));
        onView(withId(R.id.login_login_btn))
                .perform(click());
        //onView(withId(R.id.wrongNameError))
               // .check(matches(withText("Wrong Name Entered")));


    }

    @Test
    public void sign_in_empty_password_feild() {

        onView(withId(R.id.login_username))
                .perform(replaceText("Avrq17123"));
        onView(withId(R.id.login_password))
                .perform(replaceText(""));
        onView(withId(R.id.login_login_btn))
                .perform(click());
        //onView(withId(R.id.wrongNameError))
        // .check(matches(withText("Wrong Name Entered")));




    }

    @Test
    public void sign_in_invalid_email() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.login_username))
                .perform(replaceText("joshua"));
        onView(withId(R.id.login_password))
                .perform(replaceText("SJk3249!"));
        onView(withId(R.id.login_login_btn))
                .perform(click());
        //onView(withId(R.id.wrongNameError))
        // .check(matches(withText("Wrong Name Entered")));



    }

    @Test
    public void sign_uin_invalid_password() {

        onView(withId(R.id.login_username))
                .perform(replaceText("joshua@gmail.com"));
        onView(withId(R.id.login_password))
                .perform(replaceText("aaaaaa"));
        onView(withId(R.id.login_login_btn))
                .perform(click());
        //onView(withId(R.id.wrongNameError))
        // .check(matches(withText("Wrong Name Entered")));


    }

    @Test
    public void correct_sign_in_input_name_and_email() {

        onView(withId(R.id.login_username))
                .perform(replaceText("joshua@gmail.com"));
        onView(withId(R.id.login_password))
                .perform(replaceText("SJk3249!"));
        onView(withId(R.id.login_login_btn))
                .perform(click());
        //onView(withId(R.id.wrongNameError))
        // .check(matches(withText("Wrong Name Entered")));

    }
*/


    /* Iteration 1 USER STORY 2 TESTS */

    @Test
    public void sign_up_email_incorrect() {

        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Syms"));
        onView(withId(R.id.signup_email))
                .perform(replaceText("jcaedgan"));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_password))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_signup_btn))
               .perform(click());
        onView(withId(R.id.error_errorPage))
         .check(matches(withText("There was an error setting up your account, please try again")));

    }
    @Test
    public void sign_up_password_feild_empty() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Syms"));
        onView(withId(R.id.signup_email))
                .perform(replaceText("jcaedgan@gmail.com"));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText(""));
        onView(withId(R.id.signup_password))
                .perform(replaceText("Avrqt17129"));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));
    }
    @Test
    public void sign_up_password_check_feild_empty() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Syms"));
        onView(withId(R.id.signup_email))
                .perform(replaceText("jcaedgan@gmail.com"));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("Avrqt17129"));
        onView(withId(R.id.signup_password))
                .perform(replaceText(""));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));
    }

    @Test
    public void sign_up_password_invalid_entry() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Syms"));
        onView(withId(R.id.signup_email))
                .perform(replaceText("jcaedgan@gmail.com"));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("a"));
        onView(withId(R.id.signup_password))
                .perform(replaceText("a"));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));
    }
    @Test
    public void passwords_dont_match() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Syms"));
        onView(withId(R.id.signup_email))
                .perform(replaceText("jcaedgan@gmail.com"));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_password))
                .perform(replaceText("Avrqt17129"));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));
    }

    @Test
    public void sign_up_empty_email_feild() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Syms"));
        onView(withId(R.id.signup_email))
                .perform(replaceText(""));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_password))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));


    }
    @Test
    public void sign_up_empty_id_feild() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText(""));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("Joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Syms"));
        onView(withId(R.id.signup_email))
                .perform(replaceText("jcadegan@gmail.com"));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_password))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));

    }


    @Test
    public void sign_up_empty_first_name_feild() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText(""));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Syms"));
        onView(withId(R.id.signup_email))
                .perform(replaceText("jcadegan@gmail.com"));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_password))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));

    }

    @Test
    public void sign_up_empty_last_name_feild() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("Joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText(""));
        onView(withId(R.id.signup_email))
                .perform(replaceText("jcadegan@gmail.com"));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_password))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));
    }

    @Test
    public void sign_up_empty_email() {
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.login_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_username))
                .perform(replaceText("js53711"));
        onView(withId(R.id.signup_firstname))
                .perform(replaceText("Joshua"));
        onView(withId(R.id.signup_lastname))
                .perform(replaceText("Cadegan"));
        onView(withId(R.id.signup_email))
                .perform(replaceText(""));
        onView(withId(R.id.signup_confirmpassword))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_password))
                .perform(replaceText("Avrqt17123"));
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.signup_signup_btn))
                .perform(click());
        onView(withId(R.id.error_errorPage))
                .check(matches(withText("There was an error setting up your account, please try again")));

    }

    @Test
    public void correct_sign_up() {

            onView(withId(R.id.login_signup_btn))
                    .perform(click());
            onView(withId(R.id.login_signup_btn))
                    .perform(click());
            onView(withId(R.id.signup_username))
                    .perform(replaceText("js53711"));
            onView(withId(R.id.signup_firstname))
                    .perform(replaceText("Joshua"));
            onView(withId(R.id.signup_lastname))
                    .perform(replaceText("Syms"));
            onView(withId(R.id.signup_email))
                    .perform(replaceText("jcadegan@gmail.com"));
            onView(withId(R.id.signup_confirmpassword))
                    .perform(replaceText("Avrqt17123"));
            onView(withId(R.id.signup_password))
                    .perform(replaceText("Avrqt17123"));
            onView(withId(R.id.signup_signup_btn))
                    .perform(click());
            onView(withId(R.id.welcome))
             .check(matches(withText("Welcome js53711")));

        }
}



