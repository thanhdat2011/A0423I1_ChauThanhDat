package _00_Ex_Exam.Helper;

import _00_Ex_Exam.Util.Validation;

import java.util.Scanner;

public class Helper {
    private static final Scanner sc = new Scanner(System.in);
    public static String inputString() {
        String input;
        do {
            input = sc.nextLine();

            if (!Validation.isInputValid(input)) {
                System.out.println("Pls enter something !!!");
            }
        } while (!Validation.isInputValid(input));

        return input;
    }

    public static double inputPrice() {
        double price;
        do {
            price = Double.parseDouble(sc.nextLine());

            if (!Validation.isValidPrice(price)) {
                System.out.println("Price must be greater than 50 !!!");
            }
        } while (!Validation.isValidPrice(price));

        return price;
    }
    public static int inputId() {
        int id;
        do {
            id = Integer.parseInt(sc.nextLine());

            if (!Validation.isValidPrice(id)) {
                System.out.println("Price must be greater than 50 !!!");
            }
        } while (!Validation.isValidPrice(id));

        return id;
    }


}
