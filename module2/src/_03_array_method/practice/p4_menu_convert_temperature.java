package _03_array_method.practice;

import java.util.Scanner;

public class p4_menu_convert_temperature {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("MENU");
        System.out.println("1. F to C");
        System.out.print("2. C to F");
        int choice;
        do {
            System.out.println("\n");
            double num;
            System.out.print("Your Choice : ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Input F temperature : ");
                    num = Integer.parseInt(sc.nextLine());
                    System.out.println(fToC(num));
                    break;
                case 2:
                    System.out.print("Input C temperature : ");
                    num = Integer.parseInt(sc.nextLine());
                    System.out.println(ctoF(num));
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        } while (true);
    }

    public static double fToC(double val) {
        return ((5.0)/9 * (val - 32));
    }
    public static double ctoF(double val) {
        return (val/(5.0/9) + 32);
    }
}
