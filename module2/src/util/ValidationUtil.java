package util;

import java.util.Scanner;

public class ValidationUtil {
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    // Validation input without empty
    public static String inputWithOutEmpty(String field){
        String res = null;

        do {
            System.out.printf(res != null ? "This %s cannot empty. Please input again : " : field + " : ", field);
            res = getScanner().nextLine();
        }while (res.isBlank());

        return res;
    }

    // Validation input for Integer.parseInt(input) such as int id;
    public static int inputForParseInteger(String field){
        String res = inputWithOutEmpty(field);
        while (!isInteger(res)){
            System.out.println("Input number!!! Please input again");
            res = inputWithOutEmpty(field);
        }
        return Integer.parseInt(res);
    }

    // Validation input for Double.parseDouble(input) such as double price;
    public static int inputForParseDouble(String field){
        String res = inputWithOutEmpty(field);
        while (!isInteger(res)){
            System.out.println("Input number!!! Please input again");
            res = inputWithOutEmpty(field);
        }
        return Integer.parseInt(res);
    }

    /*
    Validation input for name must be start by DT
    public static String inputName(){
        String res = inputWithOutEmpty("Name");
        while (!res.matches("^DT.+")){
            res = inputWithOutEmpty("Name have to start by DT. Please input again");
        }

        return res;
    }
    */


    // Validation input for price must be > 50
    public static Double inputPriceGreaterThan50(String field) {
        String res = inputWithOutEmpty(field);
        while (!isDouble(res) || Double.parseDouble(res) <= 50){
            if (!isDouble(res)) {
                System.out.println("Pls input number !!! Please input again");
            } else {
                System.out.printf("This %s have to greater than 50. Please input again\n", field);
            }
            res = inputWithOutEmpty(field);
        }

        return Double.parseDouble(res);
    }

    //
    public static double inputDoubleGreaterThan0(String field) {
        String res = inputWithOutEmpty(field);
        while (!isDouble(res) || Double.parseDouble(res) <= 0){
            if (!isDouble(res)) {
                System.out.println("Pls input number !!! Please input again");
            } else {
                System.out.printf("This %s have to greater than 0. Please input again\n", field);
            }
            res = inputWithOutEmpty(field);
        }

        return Double.parseDouble(res);
    }

    //
    public static int inputIntegerGreaterThan0(String field) {
        String res = inputWithOutEmpty(field);
        while (!isInteger(res) || Integer.parseInt(res) <= 0){
            if (!isInteger(res)) {
                System.out.println("Pls input number !!! Please input again");
            } else {
                System.out.printf("This %s have to greater than 0. Please input again\n", field);
            }
            res = inputWithOutEmpty(field);
        }

        return Integer.parseInt(res);
    }

    // Validation for choice
    public static int getChoice() {
        String res = inputWithOutEmpty("Choice");
        while (!isInteger(res)){
            System.out.println("Input number!!! Please input again");
            res = inputWithOutEmpty("Choice");
        }

        return Integer.parseInt(res);
    }

    // ===================================================
    // This is support method for validation method above (handle NumberFormatException)
    private static boolean isInteger(String val){
        if(val == null){
            return false;
        }

        try {
            Integer.parseInt(val);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    private static boolean isDouble(String val){
        if(val == null){
            return false;
        }

        try {
            Double.parseDouble(val);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    //======================================================
}
