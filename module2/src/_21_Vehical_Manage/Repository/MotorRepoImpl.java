package _21_Vehical_Manage.Repository;

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

public class MotorRepoImpl implements VehicalRepo<Motor>{
    private final static String MOTOR_PATH = "D:\\CodeGym\\module2\\src\\_21_Vehical_Manage\\Data\\motorData.csv";
    private final static List<Motor> motors = new ArrayList<>();

    public MotorRepoImpl() {
        try {
            readCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Motor motor) {
        motor.setId(motors.size()+1);
        motors.add(motor);
        writeCSV();
    }

    @Override
    public List<Motor> findAll() {
        return motors;
    }

    @Override
    public boolean deleteById(int id) {
        Iterator<Motor> iterator = motors.iterator();
        if (iterator.hasNext()) {

            Motor motor = iterator.next();

            if (motor.getId() == id) {
                motors.remove(motor);
                writeCSV();
                return true;
            }
        }
        throw new NotFoundVehicalException("Not found ID");
        //return false;
    }

    @Override
    public List<Motor> findByOwner(String owner) {
        List<Motor> res = new ArrayList<>();
        for (Motor motor : motors) {
            if (motor.getOwner().equals(owner)) {
                res.add(motor);
            }
        }
        return res;
    }

    @Override
    public void updateById(int id) {
        for (Motor e : motors) {
            if (e.getId() == id) {
                Motor motor = setMotor(id);
                motors.set(motors.indexOf(e), motor);
            }
        }
        writeCSV();
    }

    @Override
    public void sortByProduceYear() {
        motors.sort(new Comparator<Motor>() {
            @Override
            public int compare(Motor o1, Motor o2) {
                return o1.getProduceYear() - o2.getProduceYear();
            }
        });
    }

    public Motor setMotor(int id) {
        String vehicalNum = ValidationUtil.inputWithOutEmpty("Vehical Number Plate");
        int produceYear = ValidationUtil.inputForParseInteger("Produce Year");
        String band = ValidationUtil.inputWithOutEmpty("Band");
        String owner = ValidationUtil.inputWithOutEmpty("Owner");
        int load = ValidationUtil.inputForParseInteger("Load");
        return new Motor(id, vehicalNum, produceYear, band, owner, load);
    }
    private static void readCSV() throws Exception{
        FileReader fileReader = new FileReader(MOTOR_PATH);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");

            int id = Integer.parseInt(row[0]);
            String vehicalNum = row[1];
            int produceYear = Integer.parseInt(row[2]);;
            String band = row[3];
            String owner = row[4];
            double load = Double.parseDouble(row[5]);

            Motor motor = new Motor(id, vehicalNum, produceYear, band, owner, load);
            motors.add(motor);
        }
        br.close();
    }

    private static void writeCSV(){
        try {
            FileWriter fileWriter = new FileWriter(MOTOR_PATH, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Motor motor: motors){
                bw.write(motor.getId()+ "," + motor.getVehicalNum() + "," + motor.getProduceYear()+ "," + motor.getBand()+ "," + motor.getOwner()+ "," + motor.getLoad() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
