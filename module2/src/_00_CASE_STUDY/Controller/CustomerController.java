package _00_CASE_STUDY.Controller;

import _00_CASE_STUDY.Model.Customer;
import _00_CASE_STUDY.Model.Employee;
import _00_CASE_STUDY.Service.CustomerService.CustomerService;
import _00_CASE_STUDY.Service.CustomerService.CustomerServiceImpl;
import _00_Ex_Exam.Helper.Helper;

import java.util.Scanner;

public class CustomerController {
    private static CustomerService customerService = new CustomerServiceImpl();
    static Scanner sc = new Scanner(System.in);
    public static void showMenu() {
        do {
            System.out.println("\n====> Customer Management <====");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");

            System.out.print("Your choice : ");
            int select;
            select = Integer.parseInt(sc.nextLine());

            switch (select) {
                case 1:
                    customerService.displayCustomer();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    editCustomer();
                    break;
                case 4:

                case 0:
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE");
            }
        } while (true);
    }
    public static void addCustomer() {
        System.out.print("Enter id : ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name : ");
        String name = sc.nextLine();
        System.out.print("Enter gender : ");
        String gender = sc.nextLine();
        System.out.print("Enter phone number : ");
        long phone = Integer.parseInt(sc.nextLine());
        Customer customer = new Customer(id, name, gender, phone);
        customerService.addCustomer(customer);
    }
    public static void editCustomer() {
        System.out.print("Enter employee's ID to edit : ");
        int id = Integer.parseInt(sc.nextLine());
        customerService.editCustomer(id);
    }
}
