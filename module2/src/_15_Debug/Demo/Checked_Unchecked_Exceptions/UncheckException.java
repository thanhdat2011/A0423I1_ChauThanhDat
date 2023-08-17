package _15_Debug.Demo.Checked_Unchecked_Exceptions;

public class UncheckException {
    public static void main(String[] args) {
        String name = null;
        printlength(name);
    }
    private static void printlength(String myString) {
        try {
            System.out.println(myString.length());
        }
        catch (NullPointerException npe) {
            System.err.println("String can not be null");
        }
    }
}


