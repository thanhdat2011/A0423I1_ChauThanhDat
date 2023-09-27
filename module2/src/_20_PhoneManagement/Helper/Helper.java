package _20_PhoneManagement.Helper;

import util.ValidationUtil;

import java.util.Scanner;

public class Helper {
    private final static Scanner sc = new Scanner(System.in);
    public String getInput(String field) {
        System.out.print(field + " : ");
        return sc.nextLine();
    }
    public int choicePhone() {
        System.out.print("""
                ==================
                1. Authentic Phone
                2. Hand Phone
                """);
        return getChoice();
    }
    public int choiceVehical() {
        System.out.print("""
                ==================
                1. Car
                2. Motor
                3. Truck
                """);
        return getChoice();
    }
    public int getChoice() {
        //System.out.print("Enter your choice : ");
        return Integer.parseInt(ValidationUtil.inputWithOutEmpty("Choice"));
    }
}
