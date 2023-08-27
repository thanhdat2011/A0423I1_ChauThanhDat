package _19_String_Regex.Exercise.Validate_PhoneNum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

    //    Số điện thoại hợp lệ cần đạt theo mẫu sau: (xx)-(0xxxxxxxxx)
    //    x là ký tự số
    //    Không chứa các ký tự đặc biệt
    private Pattern pattern;
    private Matcher matcher;
    private final static String PHONE_NUMBER_REGEX = "\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$";

    public PhoneNumber() {
        pattern = Pattern.compile(PHONE_NUMBER_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
