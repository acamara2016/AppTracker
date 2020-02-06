package com.example.softwareen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidoator {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "(^[a-zA-Z0-9]{6,12}$)";

    public PasswordValidoator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean validate(final String password) {

        matcher = pattern.matcher(password);
        return matcher.matches();

    }

}
