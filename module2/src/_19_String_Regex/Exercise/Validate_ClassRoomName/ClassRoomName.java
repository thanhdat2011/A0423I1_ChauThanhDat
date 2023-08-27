package _19_String_Regex.Exercise.Validate_ClassRoomName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassRoomName {

//    Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P
//    Không chứa các ký tự đặc biệt
//    Theo sau ký tự bắt đầu là 4 ký tự số
//    Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M
    private Pattern pattern;
    private Matcher matcher;
    private static final String CLASSROOM_REGEX = "[C|A|P][0-9]{4}[G|H|I|K|L|M]$";

    public ClassRoomName() {
        pattern = Pattern.compile(CLASSROOM_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
