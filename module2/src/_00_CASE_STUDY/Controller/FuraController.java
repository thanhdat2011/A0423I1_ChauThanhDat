package _00_CASE_STUDY.Controller;

import java.util.Scanner;

public class FuraController {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        do {
            System.out.println("\n-------------MENU--------------");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");

            System.out.print("Your choice : ");
            int select;
            select = Integer.parseInt(sc.nextLine());

            switch (select) {
                case 1:
                    EmployeeController.showMenu();
                    break;
                case 2:
                    CustomerController.showMenu();
                    break;
                case 3:
                    FacilityController.showMenu();
                    break;
                case 4:
                    BookingController.showMenu();
                    break;
                case 5:
                    PromotionController.showMenu();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE");
            }
        } while (true);
    }
}
