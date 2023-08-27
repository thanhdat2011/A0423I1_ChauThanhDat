package _19_String_Regex.Practice.Validate_Account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
//    Không chứa các ký tự đặc biệt
//    Ít nhất là 6 ký tự
//    Không chứa các ký tự viết hoa
//    Cho phép dấu gạch dưới (_)

    private Pattern pattern;
    private Matcher matcher;
    private static final String ACCOUNT_REGEX = "[a-z0-9_]{6,}$";

    public Account(){
        pattern = Pattern.compile(ACCOUNT_REGEX);
    }
    public boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
