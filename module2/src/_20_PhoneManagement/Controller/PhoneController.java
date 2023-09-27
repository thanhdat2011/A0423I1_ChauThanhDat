package _20_PhoneManagement.Controller;

import _20_PhoneManagement.Helper.Helper;
import _20_PhoneManagement.Model.AuPhone;
import _20_PhoneManagement.Model.HandPhone;
import _20_PhoneManagement.Model.PhoneBase;
import _20_PhoneManagement.Service.AuPhoneServiceImpl;
import _20_PhoneManagement.Service.BaseService;
import _20_PhoneManagement.Service.HandPhoneServiceImpl;
import util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneController {
    private static final BaseService<AuPhone> auphoneService = new AuPhoneServiceImpl();
    private static final BaseService<HandPhone> handphoneService = new HandPhoneServiceImpl();
    private static final Helper helper = new Helper();

    public static void main(String[] args) {
        displayMenu();
    }
    private static void displayMenu(){
        do {
            System.out.print("""
                    --------MENU--------
                    1.Create
                    2.Delete By Id
                    3.Find By Name
                    4.Display List
                    5.Exit
                    """);
            int choice;
            do {
                choice = ValidationUtil.getChoice();
                //choice = Integer.parseInt(ValidationUtil.inputWithOutEmpty("Choice"));
                if (choice < 0 || choice > 5) {
                    System.out.println("Invalid choice !!!");
                }
            } while (choice < 0 || choice > 5);
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    deleteById();
                    break;
                case 3:
                    findByName();
                    break;
                case 4:
                    displayList();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }

    public static void create(){
        int choice;
        do {
            choice = helper.choicePhone();
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid Choice !!!");
            }
        } while (choice < 0 || choice > 2);
            //int id = Integer.parseInt(helper.getInput("ID : "));

            String name = helper.getInput("Name");
//            double price = Double.parseDouble(helper.getInput("Price"));
            double price = ValidationUtil.inputPriceGreaterThan50("Price");
            String manufacture = helper.getInput("Manufacture");

            switch (choice) {
                case 1:
                    int maintainByYear = Integer.parseInt(helper.getInput("maintainByYear"));
                    String maintainCode = helper.getInput("maintainCode");
                    AuPhone auPhone = new AuPhone(0, name, price, manufacture, maintainByYear, maintainCode);
                    auphoneService.create(auPhone);
                    break;
                case 2:
                    String nation = helper.getInput("Nation");
                    String status = helper.getInput("Status");
                    HandPhone handPhone = new HandPhone(0, name, price, manufacture, nation, status);
                    handphoneService.create(handPhone);
                    break;
            }

        System.out.printf("Add %s successfully !!!\n", name);
    }
    public static void displayList(){
        int choice;
        do {
            choice = helper.choicePhone();
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid Choice !!!");
            }
        } while (choice < 0 || choice > 2);

        switch (choice) {
            case 1:
                List<AuPhone> auPhones = auphoneService.display();
                auPhones.forEach(System.out::println);
                break;
            case 2:
                List<HandPhone> handPhones = handphoneService.display();
                handPhones.forEach(System.out::println);
                break;
        }
    }

    public static void deleteById(){
        int choice;
        do {
            choice = helper.choicePhone();
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid Choice !!!");
            }
        } while (choice < 0 || choice > 2);

        int id = Integer.parseInt(helper.getInput("ID"));
        switch (choice) {
            case 1:
                if (auphoneService.deleteById(id)){
                    System.out.println("Delete successfully !!!");
                } else {
                    System.out.println("Not found");
                }
                break;
            case 2:
                if (handphoneService.deleteById(id)){
                    System.out.println("Delete successfully !!!");
                } else {
                    System.out.println("Not found");
                }
                break;
        }
    }
    public static void findByName(){
        int choice;
        do {
            choice = helper.choicePhone();
            if (choice < 0 || choice > 2) {
                System.out.println("Invalid Choice !!!");
            }
        } while (choice < 0 || choice > 2);

        String name = helper.getInput("Name");
        switch (choice){
            case 1:
                List<AuPhone> auPhones = auphoneService.findByName(name);
                auPhones.forEach(System.out::println);
                break;
            case 2:
                List<HandPhone> handPhones = handphoneService.findByName(name);
                handPhones.forEach(System.out::println);
                break;
        }
    }

}
