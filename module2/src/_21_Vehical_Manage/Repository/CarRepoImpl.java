package _21_Vehical_Manage.Repository;

import _21_Vehical_Manage.Model.Car;
import _21_Vehical_Manage.NotFoundVehicalException.NotFoundVehicalException;
import util.ValidationUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CarRepoImpl implements VehicalRepo<Car>{
    private final static List<Car> cars = new ArrayList<>();
    private final static String CAR_PATH = "D:\\CodeGym\\module2\\src\\_21_Vehical_Manage\\Data\\carData.csv";
    public CarRepoImpl() {
        try {
            readCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Car car) {
        car.setId(cars.size()+1);
        cars.add(car);
        writeCSV();
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public boolean deleteById(int id){
        Iterator<Car> iterator = cars.iterator();
        if (iterator.hasNext()) {

            Car car = iterator.next();

            if (car.getId() == id) {
                cars.remove(car);
                writeCSV();
                return true;
            }
        }
        throw new NotFoundVehicalException("Not found ID !!!");
        //return false;
    }

    @Override
    public List<Car> findByOwner(String owner) {
        List<Car> res = new ArrayList<>();
        for (Car car : cars) {
            if (car.getOwner().equals(owner)) {
                res.add(car);
            }
        }
        return res;
    }

    @Override
    public void updateById(int id) {
        for (Car e : cars) {
            if (e.getId() == id) {
                Car car = setCar(id);
                cars.set(cars.indexOf(e), car);
                writeCSV();
                break;
            }
        }
    }

    @Override
    public void sortByProduceYear() {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getProduceYear() - o2.getProduceYear();
            }
        });
    }

    public Car setCar(int id) {
        String vehicalNum = ValidationUtil.inputWithOutEmpty("Vehical Number Plate");
        int produceYear = ValidationUtil.inputForParseInteger("Produce Year");
        String band = ValidationUtil.inputWithOutEmpty("Band");
        String owner = ValidationUtil.inputWithOutEmpty("Owner");
        int seat = ValidationUtil.inputForParseInteger("Seat");
        String form = ValidationUtil.inputWithOutEmpty("Form");
        return new Car(id, vehicalNum, produceYear, band, owner, seat, form);
    }
    private static void readCSV() throws Exception{
        FileReader fileReader = new FileReader(CAR_PATH);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");

            int id = Integer.parseInt(row[0]);
            String vehicalNum = row[1];
            int produceYear = Integer.parseInt(row[2]);
            String band = row[3];
            String owner = row[4];
            int seat = Integer.parseInt(row[5]);
            String form = row[6];

            Car car = new Car(id, vehicalNum, produceYear, band, owner, seat, form);
            cars.add(car);
        }
        br.close();
    }

    private static void writeCSV(){
        try {
            FileWriter fileWriter = new FileWriter(CAR_PATH, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Car car: cars){
                bw.write(car.getId()+ "," + car.getVehicalNum() + "," + car.getProduceYear()+ "," + car.getBand()+ "," + car.getOwner()+ "," + car.getSeat() + "," + car.getForm() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
