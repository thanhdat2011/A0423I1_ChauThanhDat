package _19_String_Regex.Practice.Validate_Email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "(^[a-zA-Z0-9]+@[a-zA-Z0-9]+)\\.([a-zA-Z0-9]+)$";

//    private static final String EMAIL_REGEX = "\\w+@\\w+\\.\\w+$";
    public Email() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
