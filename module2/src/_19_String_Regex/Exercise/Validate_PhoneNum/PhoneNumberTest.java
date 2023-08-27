package _19_String_Regex.Exercise.Validate_PhoneNum;

public class PhoneNumberTest {
    private static PhoneNumber phoneNumber;
    private static String[] phoneNumbers = {"(84)-(0978489648)", "(84)-(097848964ac)","(84)-(1978489648)", "(a8)-(22222222)"};

    public static void main(String[] args) {
        phoneNumber = new PhoneNumber();
        for (String e : phoneNumbers) {
            boolean isvalid = PhoneNumberTest.phoneNumber.validate(e);
            System.out.println(e + " - " + isvalid);
        }
    }
}
