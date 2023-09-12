package _00_CASE_STUDY.Controller;

import java.util.Scanner;

public class BookingController {
    static Scanner sc = new Scanner(System.in);
    public static void showMenu() {
        do {
            System.out.println("\n====> Booking Management <====");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contract");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");

            System.out.print("Your choice : ");
            int select;
            select = Integer.parseInt(sc.nextLine());

            switch (select) {
                case 1:
                    System.out.println("wait update");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        } while (true);
    }
}
