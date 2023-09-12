package _00_CASE_STUDY.Controller;

import java.util.Scanner;

public class FacilityController {
    static Scanner sc = new Scanner(System.in);
    public static void showMenu() {
        do {
            System.out.println("\n====> Facility Management <====");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");

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
