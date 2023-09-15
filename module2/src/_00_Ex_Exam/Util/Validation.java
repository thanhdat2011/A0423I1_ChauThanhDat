package _00_Ex_Exam.Util;

public class Validation {
    public static final String REGEX_INPUT = "^[A-Za-z0-9].+$";
    public static final String REGEX_PRICE = "^[5-9][1-9]+$";
    public static boolean isInputValid(String val){
        return val.matches(REGEX_INPUT);
    }
    public static boolean isValidPrice(String val){
        return val.matches(REGEX_PRICE);
    }
}
