package _00_Ex_Exam.Repository;

import _00_Ex_Exam.Model.Phone;

import java.io.*;
import java.util.*;

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
    public List<Phone> displayP() {
        return phoneList;
    }

    @Override
    public boolean deleteById(int id) {
        //phoneList.removeIf(e -> e.getId() == id);
        // Nếu sử dụng vòng lặp foreach và cố gắng thêm/ xóa phần tử khỏi ArrayList bằng phương thức remove(),
        // sẽ nhận được ConcurrentModificationException.

        Iterator<Phone> iterator = phoneList.iterator();
        while (iterator.hasNext()) {

            Phone phone = iterator.next();

            if (phone.getId() == id) {
                iterator.remove();
                resetId();
                writeCSV();

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByName(String name) {

        Iterator<Phone> iterator = phoneList.iterator();
        while (iterator.hasNext()) {

            Phone phone = iterator.next();

            if (phone.getName().equals(name)) {
                iterator.remove();
                resetId();
                writeCSV();

                return true;
            }
        }
        return false;
    }

    @Override
    public List<Phone> findByName(String name) {
        List<Phone> res = new ArrayList<>();
        for (Phone e: phoneList) {
            if (e.getName().equals(name)) {
                res.add(e);
            }
        }

        return res;
    }

    @Override
    public List<Phone> findByPrice(double price) {
        List<Phone> res = new ArrayList<>();
        for (Phone e: phoneList) {
            if (e.getPrice() == price) {
                res.add(e);
            }
        }

        return res;
    }

    @Override
    public void editById(int id) {
        for (Phone e : phoneList) {
            if (e.getId() == id) {
                Phone phone = setPhone(id);
                phoneList.set(phoneList.indexOf(e), phone);
            }
        }
        writeCSV();
    }

    public void resetId() {
        for (int i=0; i < phoneList.size(); i++) {
            if (phoneList.get(i).getId() != (i+1)) {
                phoneList.get(i).setId(i+1);
            }
        }
    }

    @Override
    public void sortByPrice() {
        phoneList.sort(new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }

    @Override
    public void sortById() {
        phoneList.sort(new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return o1.getId() - o2.getId();
            }
        });
    }

    public Phone setPhone(int id) {
        System.out.print("Name : ");
        String nameP = sc.nextLine();
        System.out.print("Price : ");
        double priceP = Double.parseDouble(sc.nextLine());
        System.out.print("Band : ");
        String bandP = sc.nextLine();
        return new Phone(id, nameP, priceP, bandP);
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

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
