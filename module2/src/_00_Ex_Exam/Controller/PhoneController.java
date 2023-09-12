package _00_Ex_Exam.Controller;

import _00_Ex_Exam.Model.Phone;
import _00_Ex_Exam.Service.PhoneService;
import _00_Ex_Exam.Service.PhoneServiceImpl;

import javax.sound.midi.MidiFileFormat;
import java.io.IOException;
import java.util.Scanner;

public class PhoneController {
    private static final PhoneService phoneService = new PhoneServiceImpl();
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        displayMenu();
    }
    public static void displayMenu() {
        do {
            System.out.println("----------MENU-----------\n"
                    + "1. Display Phone List\n"
                    + "2. Add new Phone\n"
                    + "3. Delete Phone (by id)\n"
                    + "4. Find phone (by name) \n"
                    + "0. Exit"
            );

            int choice;
            do {
                System.out.print("Enter your choice : ");
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 4) {
                    System.out.println("INVALID CHOICE !!!");
                }
            } while (choice < 0 || choice > 4);

            try {
                switch (choice) {
                    case 1:
                        displayP();
                        break;
                    case 2:
                        addP();
                        break;
                    case 3:
                        deleteP();
                        break;
                    case 4:
                        findP();
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
        phoneService.displayP();
    }
    public static void addP() throws Exception {
        System.out.print("--------------------------\n");
        System.out.print("Name : ");
        String nameP = sc.nextLine();
        System.out.print("Price : ");
        double priceP = Double.parseDouble(sc.nextLine());
        System.out.print("Band : ");
        String bandP = sc.nextLine();
        Phone phone = new Phone(0, nameP, priceP, bandP);

        phoneService.addP(phone);
        System.out.printf("Add new phone %s successful \n", nameP);
    }

    public static void deleteP() {
        System.out.print("--------------------------\n");
        System.out.print("ID : ");
        int id = Integer.parseInt(sc.nextLine());

        phoneService.deleteP(id);

    }

    public static void findP() {
        System.out.print("--------------------------\n");
        System.out.print("Name : ");
        String name = sc.nextLine();

        phoneService.findP(name);
    }

}
