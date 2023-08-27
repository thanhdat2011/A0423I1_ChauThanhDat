package _19_String_Regex.Practice.Validate_Account;

public class AccountTest {
    private static Account account;

    public static final String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abCdefgh" };
    public static final String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

    public static void main(String args[]) {
        account = new Account();
        for (String account : validAccount) {
            boolean isvalid = AccountTest.account.validate(account);
            System.out.println(account + " - " + isvalid);
        }
        for (String account : invalidAccount) {
            boolean isvalid = AccountTest.account.validate(account);
            System.out.println(account + " - " + isvalid);
        }
    }
}
