package _20_PhoneManagement.Repository;

import _20_PhoneManagement.Model.AuPhone;
import _20_PhoneManagement.Model.HandPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class HandPhoneRepoIpl implements PhoneRepo<HandPhone>{
    //private static final Scanner sc = new Scanner(System.in);
    private static final String HANDPHONE_PATH = "D:\\CodeGym\\module2\\src\\_20_PhoneManagement\\data\\handPhone.csv";
    private final List<HandPhone> handPhones = new ArrayList<>();

    public HandPhoneRepoIpl() {
        try {
            readCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(HandPhone handPhone) {
        handPhone.setId(handPhones.size()+1);
        handPhones.add(handPhone);
        writeCSV();
    }


    @Override
    public List<HandPhone> display() {
        return handPhones;
    }

    @Override
    public boolean deleteById(int id) {
        Iterator<HandPhone> iterator = handPhones.iterator();
        while (iterator.hasNext()) {

            HandPhone handPhone = iterator.next();

            if (handPhone.getId() == id) {
                iterator.remove();
                resetId();
                writeCSV();

                return true;
            }
        }

        return false;
    }

    @Override
    public List<HandPhone> findByName(String name) {
        List<HandPhone> res = new ArrayList<>();
        for (HandPhone e: handPhones) {
            if (e.getName().equals(name)) {
                res.add(e);
            }
        }

        return res;
    }

    public void resetId() {
        for (int i = 0; i < handPhones.size(); i++) {
            if (handPhones.get(i).getId() != (i+1)) {
                handPhones.get(i).setId(i+1);
            }
        }
    }

    private void readCSV() throws Exception {
        FileReader fileReader = new FileReader(HANDPHONE_PATH);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while ((line = br.readLine()) != null) {

            String[] row = line.split(",");

            int id = Integer.parseInt(row[0]);
            String name = row[1];
            double price = Double.parseDouble(row[2]);
            String manufacture = row[3];
            String nation = row[4];
            String status = row[5];

            HandPhone handPhone = new HandPhone(id, name, price, manufacture, nation, status);

            handPhones.add(handPhone);

        }
        br.close();
    }
    private void writeCSV() {
        try {
            FileWriter fileWriter = new FileWriter(HANDPHONE_PATH, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (HandPhone handPhone : handPhones) {
                bw.write(handPhone.getId() + "," + handPhone.getName() + "," + handPhone.getPrice() + "," + handPhone.getManufacture() + "," + handPhone.getNation() + "," + handPhone.getStatus() +"\n");
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
