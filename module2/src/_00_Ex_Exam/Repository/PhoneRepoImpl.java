package _00_Ex_Exam.Repository;

import _00_Ex_Exam.Model.Phone;
import _16_IO_TextFile.Exercise.ReadFileCSV.Nation;
import _17_IO_BinaryFile.Exercise.ProductManagement.Model.Product;

import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneRepoImpl implements PhoneRepo {
    private static Scanner sc = new Scanner(System.in);
    private final static String FILE_PATH = "D:\\CodeGym\\module2\\src\\_00_Ex_Exam\\Data\\data.csv";
    private List<Phone> phoneList = new ArrayList<>();

    public PhoneRepoImpl() {
        try {
            readCSV();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addP(Phone phone) {
        phone.setId(phoneList.size()+1);
        phoneList.add(phone);

        writeCSV();
    }

    @Override
    public void displayP() {
        phoneList.forEach(System.out::println);
    }

    @Override
    public void deleteP(int id) {
        phoneList.removeIf(e -> e.getId() == id);
        resetId();
        writeCSV();
    }

    @Override
    public void findP(String name) {
        List<Phone> res = new ArrayList<>();
        for (Phone e: phoneList) {
            if (e.getName().equals(name)) {
                res.add(e);
            }
        }
        if (res.size() > 0) {
            res.forEach(System.out::println);
        } else {
            System.out.println("Not Found !!!");
        }
    }
    public void resetId() {
        for (int i=0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getId() != (i+1)) {
                phoneList.get(i).setId(i+1);
            }
        }
    }

    public void readCSV() throws Exception {
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while ((line = br.readLine()) != null) {

            String[] row = line.split(",");

            int id = Integer.parseInt(row[0]);
            String name = row[1];
            double price = Double.parseDouble(row[2]);
            String band = row[3];

            Phone phone = new Phone(id, name, price, band);
            phoneList.add(phone);
        }
        br.close();
    }
    public void writeCSV() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Phone phone : phoneList) {
                bw.write(phone.getId() + "," + phone.getName() + "," + phone.getPrice() + "," + phone.getBand() + "\n");
            }
//            bw.write(phone.getId() + "," + phone.getName() + "," + phone.getPrice() + "," + phone.getBand() + "\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
