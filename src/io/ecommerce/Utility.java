package io.ecommerce;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class Utility {
    private Utility() {}

    public static String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public static boolean isEmailValid(String email) {
        try {
            return Pattern.compile(emailRegex).matcher(email).matches();
        }
        catch (PatternSyntaxException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        try {
            long phone = Long.parseLong(phoneNumber);
            return true;
        }
        catch (NumberFormatException exception) {
            exception.printStackTrace();
            return false;
        }
    }
}