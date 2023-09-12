package _00_CASE_STUDY.Controller;

import java.util.Scanner;

public class PromotionController {
    static Scanner sc = new Scanner(System.in);
    public static void showMenu() {
        do {
            System.out.println("\n====> Promotion Management <====");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");

            System.out.print("Your choice : ");
            int select;
            select = Integer.parseInt(sc.nextLine());

            switch (select) {
                case 1:
                    System.out.println("wait update");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE");
            }
        } while (true);
    }
}
