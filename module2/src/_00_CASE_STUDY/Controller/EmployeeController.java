package _00_CASE_STUDY.Controller;

import _00_CASE_STUDY.Model.Employee;
import _00_CASE_STUDY.Service.EmployeeService.EmployeeService;
import _00_CASE_STUDY.Service.EmployeeService.EmployeeServiceImpl;

import java.sql.SQLOutput;
import java.util.Scanner;

public class EmployeeController {
    private static EmployeeService employeeService = new EmployeeServiceImpl();
    static Scanner sc = new Scanner(System.in);
    public static void showMenu() {
        do {
            System.out.println("\n====> Employee Management <====");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");

            System.out.print("Your choice : ");
            int select;
            select = Integer.parseInt(sc.nextLine());

            switch (select) {
                case 1:
                    employeeService.displayEmployee();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    editEmployee();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE");
            }
        } while (true);
    }

    public static void addEmployee() {
        System.out.print("Enter id : ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name : ");
        String name = sc.nextLine();
        Employee employee = new Employee(id, name);
        employeeService.addEmployee(employee);
    }
    public static void editEmployee() {
        System.out.print("Enter employee's ID to edit : ");
        int id = Integer.parseInt(sc.nextLine());
        employeeService.editEmployee(id);
    }
}
