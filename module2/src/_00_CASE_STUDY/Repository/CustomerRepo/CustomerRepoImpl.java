package _00_CASE_STUDY.Repository.CustomerRepo;

import _00_CASE_STUDY.Model.Customer;
import _00_CASE_STUDY.Model.Employee;

import java.io.*;
import java.util.*;

public class CustomerRepoImpl implements CustomerRepo{
    private static final Scanner sc = new Scanner(System.in);
    private final static String PATH = "D:\\CodeGym\\module2\\src\\_00_CASE_STUDY\\Data\\customer_data.txt";
    private List<Customer> customerList = new LinkedList<>();
    public CustomerRepoImpl() {
        try {
            File file = new File(PATH);

            if (file.length() > 0) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                customerList = (List<Customer>) ois.readObject();
                ois.close();
            }
        }
        catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void displayCustomer() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        writeObject(customerList);
    }

    @Override
    public void editCustomer(int id) {
        boolean isExist = false;
        for (Customer e : customerList) {
            if (e.getId() == id) {
                isExist = true;
                System.out.println("Employee does exist !");
                System.out.println(e);

                System.out.print("Enter new ID : ");
                int idC = Integer.parseInt(sc.nextLine());
                System.out.print("Enter new name : ");
                String nameC = sc.nextLine();
                System.out.print("Enter new gender : ");
                String genderC = sc.nextLine();
                System.out.print("Enter new phone : ");
                long phoneC = Integer.parseInt(sc.nextLine());
                Customer customer   = new Customer(idC, nameC, genderC, phoneC);

                customerList.set(customerList.indexOf(e), customer);

            }
        }

        if (!isExist) {
            System.out.println("Employee does not exist !!!");
        }

        writeObject(customerList);
    }
    public static void writeObject(List<Customer> customerList) {
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customerList);
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
