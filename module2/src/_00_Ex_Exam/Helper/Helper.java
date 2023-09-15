package _00_Ex_Exam.Helper;

import _00_Ex_Exam.Util.Validation;

import java.util.Scanner;

public class Helper {
    private static final Scanner sc = new Scanner(System.in);
    public static String input() {
        String input;
        do {
            //System.out.print("Name : ");
            input = sc.nextLine();
            if (!Validation.isInputValid(input)) {
                System.out.println("Pls enter something !!!");
            }
        } while (!Validation.isInputValid(input));
        return input;
    }
}
