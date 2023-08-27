package _19_String_Regex.Practice.Validate_Email;

public class EmailTest {
    private static Email email;
    public static final String[] validEmail = new String[] { "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
    public static final String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String[] args) {
        email = new Email();
        for (String email : validEmail) {
            boolean isvalid = EmailTest.email.validate(email);
            System.out.println(email + " - " + isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = EmailTest.email.validate(email);
            System.out.println(email + " - " + isvalid);
        }
    }
}
