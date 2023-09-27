package _21_Vehical_Manage.Controller;

import _21_Vehical_Manage.Model.Car;
import _21_Vehical_Manage.Model.Motor;
import _21_Vehical_Manage.Model.Truck;
import _21_Vehical_Manage.NotFoundVehicalException.NotFoundVehicalException;
import _21_Vehical_Manage.Service.BaseService;
import _21_Vehical_Manage.Service.CarServiceImpl;
import _21_Vehical_Manage.Service.MotorServiceImpl;
import _21_Vehical_Manage.Service.TruckServiceImpl;
import util.HelperUtil;
import util.ValidationUtil;

import java.util.List;

public class VehicalController {
    private final static BaseService<Car> carService = new CarServiceImpl();
    private final static BaseService<Motor> motorService = new MotorServiceImpl();
    private final static BaseService<Truck> truckService = new TruckServiceImpl();
    public static void main(String[] args) {
        displayMenu();
    }
    public static void displayMenu(){
        do {
            System.out.println("""
                    ============= MENU =============
                    1. Create
                    2. Delete By Id
                    3. Find by owner
                    4. Display
                    5. Update by id
                    6. Sort by price
                    7. Exit
                    ================================
                    """);

            int choice;
            do {
                choice = ValidationUtil.getChoice();
                if (choice < 0 || choice > 7){
                    System.out.println("INVALID CHOICE !!!");
                }
            } while (choice < 0 || choice > 7);

            switch (choice) {
                case 1 -> create();
                case 2 -> deleteById();
                case 3 -> findByOwner();
                case 4 -> display();
                case 5 -> updateById();
                case 6 -> sortByPrice();
                case 7 -> System.exit(0);
            }

        } while (true);
    }

    private static void create(){
        int choice;
        do {
            choice = HelperUtil.choiceVehical();
            if (choice < 0 || choice > 3){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 3);

        /*
         int id = Integer.parseInt(ValidationUtil.inputWithOutEmpty("ID"));
         int id = ValidationUtil.inputForParseInteger("ID");
        */
        String vehicalNum = ValidationUtil.inputWithOutEmpty("Vehical Number Plate");
        int produceYear = ValidationUtil.inputForParseInteger("Produce Year");
        String band = ValidationUtil.inputWithOutEmpty("Band");
        String owner = ValidationUtil.inputWithOutEmpty("Owner");

        switch (choice) {
            case 1:
                int seat = ValidationUtil.inputForParseInteger("Seat");
                String form = ValidationUtil.inputWithOutEmpty("Form");
                carService.add(new Car(0, vehicalNum, produceYear, band, owner, seat, form));
                break;
            case 2:
                int load = ValidationUtil.inputForParseInteger("Load");
                motorService.add(new Motor(0, vehicalNum, produceYear, band, owner, load));
                break;
            case 3:
                double wattage = ValidationUtil.inputForParseDouble("Wattage");
                truckService.add(new Truck(0, vehicalNum, produceYear, band, owner, wattage));
                break;
        }

        System.out.println("Create successfully!!!");
    }

    private static void deleteById(){
        int choice;
        do {
            choice = HelperUtil.choiceVehical();
            if (choice < 0 || choice > 3){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 3);

        // Have not handled "Delete when empty list"
        boolean isExist;
        do {
            try {
                int id = ValidationUtil.inputForParseInteger("ID");
                switch (choice) {
                    case 1 -> carService.deleteById(id);
                    case 2 -> motorService.deleteById(id);
                    case 3 -> truckService.deleteById(id);
                }
                System.out.println("Delete successfully !!!");
                isExist = true;
            }
            catch (NotFoundVehicalException e) {
                isExist = false;
                System.out.println(e.getMessage() + "\nPlease input ID again");
            }

        } while (!isExist);


    }
    private static void findByOwner(){
        int choice;
        do {
            choice = HelperUtil.choiceVehical();
            if (choice < 0 || choice > 3){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 3);

        String owner = ValidationUtil.inputWithOutEmpty("Owner");
        switch (choice) {
            case 1 -> carService.findByOwner(owner).forEach(System.out::println);
            case 2 -> motorService.findByOwner(owner).forEach(System.out::println);
            case 3 -> truckService.findByOwner(owner).forEach(System.out::println);
        }
    }
    private static void display(){
        int choice;
        do {
            choice = HelperUtil.choiceVehical();
            if (choice < 0 || choice > 3){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 3);

        switch (choice) {
//            case 1 -> carService.findAll().forEach(System.out::println);
            case 1 -> {
                List<Car> res = carService.findAll();
                for (Car car : res){
                    System.out.println(car.toVehical());
                }
            }
            case 2 -> motorService.findAll().forEach(System.out::println);
            case 3 -> truckService.findAll().forEach(System.out::println);
        }
    }

    private static void updateById(){
        int choice;
        do {
            choice = HelperUtil.choiceVehical();
            if (choice < 0 || choice > 3){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 3);

        int id = ValidationUtil.inputForParseInteger("ID");

        switch (choice) {
            case 1 -> carService.updateById(id);
            case 2 -> motorService.updateById(id);
            case 3 -> truckService.updateById(id);
        }

        System.out.println("Update successfully !!!");
    }

    private static void sortByPrice(){
        int choice;
        do {
            choice = HelperUtil.choiceVehical();
            if (choice < 0 || choice > 3){
                System.out.println("INVALID CHOICE !!!");
            }
        }while (choice < 0 || choice > 3);

        switch (choice) {
            case 1 -> carService.sortByProduceYear();
            case 2 -> motorService.sortByProduceYear();
            case 3 -> truckService.sortByProduceYear();
        }

        System.out.println("Done Sort by produce year !!!");
    }
}
