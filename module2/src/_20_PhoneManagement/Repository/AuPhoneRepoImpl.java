package _20_PhoneManagement.Repository;

import _00_Ex_Exam.Model.Phone;
import _20_PhoneManagement.Model.AuPhone;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AuPhoneRepoImpl implements PhoneRepo<AuPhone> {
    //private static final Scanner sc = new Scanner(System.in);
    private static final String AUPHONE_PATH = "D:\\CodeGym\\module2\\src\\_20_PhoneManagement\\data\\auPhone.csv";
    private final List<AuPhone> auPhones = new ArrayList<>();

    public AuPhoneRepoImpl() {
        try {
            readCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(AuPhone auPhone) {
        auPhone.setId(auPhones.size() + 1);
        auPhones.add(auPhone);

        writeCSV();
    }

    @Override
    public List<AuPhone> display() {
        return auPhones;
    }

    @Override
    public boolean deleteById(int id) {
        Iterator<AuPhone> iterator = auPhones.iterator();
        while (iterator.hasNext()) {

            AuPhone auPhone = iterator.next();

            if (auPhone.getId() == id) {
                iterator.remove();
                resetId();
                writeCSV();

                return true;
            }
        }

        return false;
    }

    @Override
    public List<AuPhone> findByName(String name) {
        List<AuPhone> res = new ArrayList<>();
        for (AuPhone e: auPhones) {
            if (e.getName().equals(name)) {
                res.add(e);
            }
        }

        return res;
    }

    public void resetId() {
        for (int i=0; i < auPhones.size(); i++) {
            if (auPhones.get(i).getId() != (i+1)) {
                auPhones.get(i).setId(i+1);
            }
        }
    }

    public void readCSV() throws Exception {
        FileReader fileReader = new FileReader(AUPHONE_PATH);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while ((line = br.readLine()) != null) {

            String[] row = line.split(",");

            int id = Integer.parseInt(row[0]);
            String name = row[1];
            double price = Double.parseDouble(row[2]);
            String manufacture = row[3];
            int maintainByYear = Integer.parseInt(row[4]);
            String maintainCode = row[5];

            AuPhone auPhone = new AuPhone(id, name, price, manufacture, maintainByYear, maintainCode);

            auPhones.add(auPhone);
        }
        br.close();
    }
    private void writeCSV() {
        try {
            FileWriter fileWriter = new FileWriter(AUPHONE_PATH, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (AuPhone auPhone : auPhones) {
                bw.write(auPhone.getId() + "," + auPhone.getName() + "," + auPhone.getPrice() + "," + auPhone.getManufacture() + "," + auPhone.getMaintainByYear() + "," + auPhone.getMaintainCode() +"\n");
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
