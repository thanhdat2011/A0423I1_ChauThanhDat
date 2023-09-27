package _21_Vehical_Manage.Repository;

import Demo.Test;
import _21_Vehical_Manage.Model.Car;
import _21_Vehical_Manage.Model.Motor;
import _21_Vehical_Manage.Model.Truck;
import _21_Vehical_Manage.NotFoundVehicalException.NotFoundVehicalException;
import util.ValidationUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TruckRepoImpl implements VehicalRepo<Truck>{
    private final static String TRUCK_PATH = "D:\\CodeGym\\module2\\src\\_21_Vehical_Manage\\Data\\truckData.csv";
    private final static List<Truck> trucks = new ArrayList<>();

    public TruckRepoImpl() {
        try {
            readCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Truck truck) {
        truck.setId(trucks.size()+1);
        trucks.add(truck);
    }

    @Override
    public List<Truck> findAll() {
        return trucks;
    }

    @Override
    public boolean deleteById(int id) {
        Iterator<Truck> iterator = trucks.iterator();
        if (iterator.hasNext()) {

            Truck truck = iterator.next();

            if (truck.getId() == id) {
                trucks.remove(truck);
                return true;
            }
        }
        throw new NotFoundVehicalException("Not found ID");
        //return false;
    }

    @Override
    public List<Truck> findByOwner(String owner) {
        List<Truck> res = new ArrayList<>();
        for (Truck truck : trucks) {
            if (truck.getOwner().equals(owner)) {
                res.add(truck);
            }
        }
        return res;
    }

    @Override
    public void updateById(int id) {
        for (Truck e : trucks) {
            if (e.getId() == id) {
                Truck truck = setTruck(id);
                trucks.set(trucks.indexOf(e), truck);
            }
        }
        writeCSV();
    }

    @Override
    public void sortByProduceYear() {
        trucks.sort(new Comparator<Truck>() {
            @Override
            public int compare(Truck o1, Truck o2) {
                return o1.getProduceYear() - o2.getProduceYear();
            }
        });
    }

    public Truck setTruck(int id) {
        String vehicalNum = ValidationUtil.inputWithOutEmpty("Vehical Number Plate");
        int produceYear = ValidationUtil.inputForParseInteger("Produce Year");
        String band = ValidationUtil.inputWithOutEmpty("Band");
        String owner = ValidationUtil.inputWithOutEmpty("Owner");
        double wattage = ValidationUtil.inputForParseDouble("Wattage");
        return new Truck(id, vehicalNum, produceYear, band, owner, wattage);
    }
    private static void readCSV() throws Exception{
        FileReader fileReader = new FileReader(TRUCK_PATH);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");

            int id = Integer.parseInt(row[0]);
            String vehicalNum = row[1];
            int produceYear = Integer.parseInt(row[2]);;
            String band = row[3];
            String owner = row[4];
            double wattage = Double.parseDouble(row[5]);

            Truck truck = new Truck(id, vehicalNum, produceYear, band, owner, wattage);
            trucks.add(truck);
        }
        br.close();
    }

    private static void writeCSV() {
        try {
            FileWriter fileWriter = new FileWriter(TRUCK_PATH, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Truck truck : trucks) {
                bw.write(truck.getId() + "," + truck.getVehicalNum() + "," + truck.getProduceYear() + "," + truck.getBand() + "," + truck.getOwner() + "," + truck.getWattage() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
