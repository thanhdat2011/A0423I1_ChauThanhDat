package _Final_Exam.Controller;

import _Final_Exam.Model.ExProduct;
import _Final_Exam.Model.ImProduct;
import _Final_Exam.NotFoundProductException.NotFoundProductException;
import _Final_Exam.Service.ExProductServiceImpl;
import _Final_Exam.Service.ImProductServiceImpl;
import _Final_Exam.Service.ProductService;
import util.HelperUtil;
import util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ProductController {
    private final static ProductService<ImProduct> imProductService = new ImProductServiceImpl();
    private final static ProductService<ExProduct> exProductService = new ExProductServiceImpl();
    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu(){
        do {
            System.out.println("""
                    ============= MENU =============
                    1. Create
                    2. Delete By Code
                    3. Display
                    4. Find by Name or Code
                    5. Exit
                    6. Search by name
                    ================================
                    """);

            int choice;
            do {
                choice = ValidationUtil.getChoice();
                if (choice <= 0 || choice > 6){
                    System.out.println("INVALID CHOICE !!!");
                }
            } while (choice < 0 || choice > 6);

            switch (choice){
                case 1 -> create();
                case 2 -> deleteByCode();
                case 3 -> display();
                case 4 -> findByNameOrCode();
                case 5 -> System.exit(0);
                case 6 -> search();
            }

        }while (true);
    }

    private static void create(){
        int choice;
        do {
            choice = HelperUtil.choiceProduct();
            if (choice <= 0 || choice > 2){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice <= 0 || choice > 2);

        String code = ValidationUtil.inputWithOutEmpty("Code");
        String name = ValidationUtil.inputWithOutEmpty("Name");
        double price = ValidationUtil.inputDoubleGreaterThan0("Price");
        int amount = ValidationUtil.inputIntegerGreaterThan0("Amount");
        String manufacture = ValidationUtil.inputWithOutEmpty("Manufacture");

        switch (choice){
            case 1:
                double imPrice = ValidationUtil.inputDoubleGreaterThan0("Immigrate Price");
                String province = ValidationUtil.inputWithOutEmpty("Province");
                double tax = ValidationUtil.inputDoubleGreaterThan0("Tax");
                ImProduct imProduct = new ImProduct(0, code, name, price, amount, manufacture, imPrice, province, tax);
                imProductService.add(imProduct);
                System.out.printf("Create %s successfully\n", imProduct.getName());
                break;
            case 2:
                double exPrice = ValidationUtil.inputDoubleGreaterThan0("Ex Price");
                String nation = ValidationUtil.inputWithOutEmpty("Nation");
                ExProduct exProduct = new ExProduct(0, code, name, price, amount, manufacture, exPrice, nation);
                exProductService.add(exProduct);
                System.out.printf("Create %s successfully\n", exProduct.getName());
                break;
        }
    }

    private static void deleteByCode(){
        int choice;
        do {
            choice = HelperUtil.choiceProduct();
            if (choice < 0 || choice > 2){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 2);

        boolean isExist;
        do {
            try {
                String code = ValidationUtil.inputWithOutEmpty("Code");
                switch (choice) {
                    case 1 -> {
                        imProductService.deleteByCode(code);
                        System.out.println("Delete successfully !!!");
                        System.out.println("List after delete");
                        imProductService.findAll().forEach(System.out::println);
                    }
                    case 2 -> {
                        exProductService.deleteByCode(code);
                        System.out.println("Delete successfully !!!");
                        System.out.println("List after delete");
                        exProductService.findAll().forEach(System.out::println);
                    }
                }
                isExist = true;
            }
            catch (NotFoundProductException e) {
                isExist = false;
                System.out.println(e.getMessage() + "\nPlease input Code again");
            }

        } while (!isExist);
    }

    private static void display(){
        int choice;
        do {
            choice = HelperUtil.choiceProduct();
            if (choice < 0 || choice > 2){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 2);

        switch (choice){
            case 1 -> {
                List<ImProduct> res = imProductService.findAll();
                for (ImProduct imProduct : res) {
                    System.out.println(imProduct.toProduct());
                }
            }
            case 2 -> exProductService.findAll().forEach(System.out::println);
        }
    }
    private static void findByNameOrCode(){
        int choice;
        do {
            choice = HelperUtil.choiceProduct();
            if (choice < 0 || choice > 2){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 2);

        String field = ValidationUtil.inputWithOutEmpty("Name or Code");
        switch (choice){
            case 1 -> imProductService.findByNameOrCode(field).forEach(System.out::println);
            case 2 -> exProductService.findByNameOrCode(field).forEach(System.out::println);
        }
    }

    private static void search(){
        int choice;
        do {
            choice = HelperUtil.choiceProduct();
            if (choice < 0 || choice > 2){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 2);

        String name = ValidationUtil.inputWithOutEmpty("Name");
        switch (choice){
            case 1 -> {
                List<ImProduct> temp;
                temp = imProductService.search(new Predicate<ImProduct>() {
                    @Override
                    public boolean test(ImProduct imProduct) {
                        return imProduct.getName().contains(name);
                    }
                });
                temp.forEach(System.out::println);
            }

            case 2 -> exProductService.search(new Predicate<ExProduct>() {
                @Override
                public boolean test(ExProduct exProduct) {
                    return Objects.equals(exProduct.getName(), name);
                }
            });
        }
    }
}
