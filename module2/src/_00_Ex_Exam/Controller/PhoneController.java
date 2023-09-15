package _00_Ex_Exam.Controller;

import _00_Ex_Exam.Helper.Helper;
import _00_Ex_Exam.Model.Phone;
import _00_Ex_Exam.Service.PhoneService;
import _00_Ex_Exam.Service.PhoneServiceImpl;
import _00_Ex_Exam.Util.Validation;

import java.util.List;
import java.util.Scanner;

public class PhoneController {
    private static final PhoneService phoneService = new PhoneServiceImpl();
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        displayMenu();
    }
    public static void displayMenu() {
        do {
            System.out.println("-----------MENU-----------\n"
                    + "1. Display Phone List\n"
                    + "2. Add new Phone\n"
                    + "3. Delete Phone (by id)\n"
                    + "4. Delete Phone (by name)\n"
                    + "5. Find phone (by name) \n"
                    + "6. Find phone (by price) \n"
                    + "7. Edit phone (by id)\n"
                    + "8. Sort (by Price)\n"
                    + "9. Sort (by id)\n"
                    + "0. Exit"
            );

            int choice;
            do {
                System.out.print("Enter your choice : ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 9) {
                    System.out.println("INVALID CHOICE !!!");
                }
            } while (choice < 0 || choice > 9);

            boolean isDone;
            try {
                switch (choice) {
                    case 1:
                        displayP();
                        break;
                    case 2:
                        do {
                            try {
                                isDone = true;
                                addP();
                            }
                            catch (NumberFormatException e) {
                                isDone = false;
                                System.out.println("Input number !!!");
                            }
                        } while (!isDone);

                        break;
                    case 3:
                        do {
                            try {
                                isDone = true;
                                deleteById();
                            }
                            catch (NumberFormatException e) {
                                isDone = false;
                                System.out.println("Input number !!!");
                            }
                        } while (!isDone);

                        break;
                    case 4:
                        do {
                            try {
                                isDone = true;
                                deleteByName();
                            }
                            catch (NumberFormatException e) {
                                isDone = false;
                                System.out.println("Input number !!!");
                            }
                        } while (!isDone);

                        break;
                    case 5:
                        findByName();
                        break;
                    case 6:
                        do {
                            try {
                                isDone = true;
                                findByPrice();
                            }
                            catch (NumberFormatException e) {
                                isDone = false;
                                System.out.println("Input number !!!");
                            }
                        } while (!isDone);

                        break;
                    case 7:
                        do {
                            try {
                                isDone = true;
                                editById();
                            }
                            catch (NumberFormatException e) {
                                isDone = false;
                                System.out.println("Input number !!!");
                            }
                        } while (!isDone);

                        break;
                    case 8:
                        sortByPrice();
                        break;
                    case 9:
                        sortById();
                        break;
                    case 0:
                        System.out.println("OUT !!!");
                        System.exit(0);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }
    public static void displayP() {
        System.out.print("--------------------------\n"
            + "Phone List\n"
        );

        List<Phone> res = phoneService.displayP();
        res.forEach(System.out::println);
    }
    public static void addP() {
        System.out.print("--------------------------\n");

        System.out.print("Name : ");
        String nameP = Helper.input();

        System.out.print("Price : ");
        double priceP = Double.parseDouble(sc.nextLine());

        System.out.print("Band : ");
        String bandP = Helper.input();

        Phone phone = new Phone(0, nameP, priceP, bandP);

        phoneService.addP(phone);
        System.out.printf("Add new phone \"%s\" successful \n", nameP);
    }

    public static void deleteById() {
        System.out.print("--------------------------\n");
        System.out.print("ID : ");
        int id = Integer.parseInt(sc.nextLine());

        if (phoneService.deleteById(id)) {
            System.out.printf("Delete successfully ID %d !!!\n",id);
        } else {
            System.out.println("Not found !!!");
        }
    }
    public static void deleteByName(){
        System.out.print("--------------------------\n");
        System.out.print("Name : ");
        String name = sc.nextLine();

        if (phoneService.deleteByName(name)) {
            System.out.printf("Delete successfully \"%s\" !!!\n",name);
        } else {
            System.out.println("Not found !!!");
        }
    }
    public static void findByName() {
        System.out.print("--------------------------\n");
        System.out.print("Name : ");
        String name = sc.nextLine();

        List<Phone> res = phoneService.findByName(name);
        res.forEach(System.out::println);
    }
    public static void findByPrice() {
        System.out.print("--------------------------\n");
        System.out.print("Price : ");
        double price = Double.parseDouble(sc.nextLine());

        List<Phone> res = phoneService.findByPrice(price);
        res.forEach(System.out::println);
    }
    public static void editById() {
        System.out.print("--------------------------\n");
        System.out.print("ID : ");
        int id = Integer.parseInt(sc.nextLine());

        phoneService.editById(id);
    }
    public static void sortByPrice() {
        System.out.print("--------------------------\n");
        phoneService.sortByPrice();
        System.out.println("Done sort by price !!!");
    }
    public static void sortById() {
        System.out.print("--------------------------\n");
        phoneService.sortById();
        System.out.println("Done sort by ID !!!");
    }
}
