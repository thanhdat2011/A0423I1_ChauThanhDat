//package _00_CASE_STUDY.Controller;
//
//import java.util.Scanner;
//
//public class FuramaController {
//    static Scanner sc = new Scanner(System.in);
//    public static void main(String[] args) {
//        displayMainMenu();
//    }
//
//    // MAIN MENU
//    private static void displayMainMenu() {
//        do {
//            System.out.println("\n-------------MENU--------------");
//            System.out.println("1. Employee Management");
//            System.out.println("2. Customer Management");
//            System.out.println("3. Facility Management");
//            System.out.println("4. Booking Management");
//            System.out.println("5. Promotion Management");
//            System.out.println("6. Exit");
//
//            System.out.print("Your choice : ");
//            int select;
//            select = Integer.parseInt(sc.nextLine());
//
//            switch (select) {
//                case 1:
//                    employeeManagement();
//                    break;
//                case 2:
//                    customerManagement();
//                    break;
//                case 3:
//                    facilityManagement();
//                    break;
//                case 4:
//                    bookingManagement();
//                    break;
//                case 5:
//                    promotionManagement();
//                    break;
//                case 6:
//                    System.exit(0);
//                default:
//                    System.out.println("INVALID CHOICE");
//            }
//        } while (true);
//    }
//
//    // 1. Employee Management
//    private static void employeeManagement() {
//        do {
//            System.out.println("\n====> Employee Management <====");
//            System.out.println("1. Display list employees");
//            System.out.println("2. Add new employee");
//            System.out.println("3. Edit employee");
//            System.out.println("4. Return main menu");
//
//            System.out.print("Your choice : ");
//            int select;
//            select = Integer.parseInt(sc.nextLine());
//
//            switch (select) {
////                case 1:
////                    displayListEmployees();
////                    break;
////                case 2:
////                    addNewEmployee();
////                    break;
////                case 3:
////                    editEmployee();
////                    break;
//                case 4:
//                    displayMainMenu();
//                    break;
//                default:
//                    System.out.println("INVALID CHOICE");
//            }
//        } while (true);
//    }
//
//    // 2. Customer Management
//    private static void customerManagement() {
//        do {
//            System.out.println("\n====> Customer Management <====");
//            System.out.println("1. Display list customers");
//            System.out.println("2. Add new customer");
//            System.out.println("3. Edit customer");
//            System.out.println("4. Return main menu");
//
//            System.out.print("Your choice : ");
//            int select;
//            select = Integer.parseInt(sc.nextLine());
//
//            switch (select) {
////                case 1:
////                    displayListCustomers();
////                    break;
////                case 2:
////                    addNewCustomer();
////                    break;
////                case 3:
////                    editCustomer();
////                    break;
//                case 4:
//                    displayMainMenu();
//                    break;
//                default:
//                    System.out.println("INVALID CHOICE");
//            }
//        } while (true);
//    }
//
//    // 3. Facility Management
//    private static void facilityManagement() {
//        do {
//            System.out.println("\n====> Facility Management <====");
//            System.out.println("1. Display list facility");
//            System.out.println("2. Add new facility");
//            System.out.println("3. Display list facility maintenance");
//            System.out.println("4. Return main menu");
//
//            System.out.print("Your choice : ");
//            int select;
//            select = Integer.parseInt(sc.nextLine());
//
//            switch (select) {
////                case 1:
////                    displayListFacility();
////                    break;
////                case 2:
////                    addNewFacility();
////                    break;
////                case 3:
////                    displayListFacilityMaintenance();
////                    break;
//                case 4:
//                    displayMainMenu();
//                    break;
//                default:
//                    System.out.println("INVALID CHOICE");
//            }
//        } while (true);
//    }
//
//    // 4. Booking Management
//    private static void bookingManagement() {
//        do {
//            System.out.println("\n====> Booking Management <====");
//            System.out.println("1. Add new booking");
//            System.out.println("2. Display list booking");
//            System.out.println("3. Create new contract");
//            System.out.println("4. Display list contracts");
//            System.out.println("5. Edit contracts");
//            System.out.println("6. Return main menu");
//
//            System.out.print("Your choice : ");
//            int select;
//            select = Integer.parseInt(sc.nextLine());
//
//            switch (select) {
////                case 1:
////                    addNewBooking();
////                    break;
////                case 2:
////                    displayListBooking();
////                    break;
////                case 3:
////                    createNewContract();
////                    break;
////                case 4:
////                    displayListContracts();
////                    break;
////                case 5:
////                    editContract();
////                    break;
//                case 6:
//                    displayMainMenu();
//                    break;
//                default:
//                    System.out.println("INVALID CHOICE");
//            }
//        } while (true);
//    }
//
//    // 5. Promotion Management
//    private static void promotionManagement() {
//        do {
//            System.out.println("\n====> Promotion Management <====");
//            System.out.println("1. Display list customers use service");
//            System.out.println("2. Display list customers get voucher");
//            System.out.println("3. Return main menu");
//
//            System.out.print("Your choice : ");
//            int select;
//            select = Integer.parseInt(sc.nextLine());
//
//            switch (select) {
////                case 1:
////                    displayListCustomersUseService();
////                    break;
////                case 2:
////                    displayListCustomersGetVoucher();
////                    break;
//                case 3:
//                    displayMainMenu();
//                    break;
//                default:
//                    System.out.println("INVALID CHOICE");
//            }
//        } while (true);
//    }
//}
