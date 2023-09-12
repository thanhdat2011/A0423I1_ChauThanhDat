package _00_CASE_STUDY.Repository.EmployeeRepo;

import _00_CASE_STUDY.Model.Employee;
import _00_CASE_STUDY.Service.EmployeeService.EmployeeService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepoImpl implements EmployeeRepo{
    private static final Scanner sc = new Scanner(System.in);
    private final static String PATH = "D:\\CodeGym\\module2\\src\\_00_CASE_STUDY\\Data\\employee_data.txt";
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeRepoImpl() {
        try {
            File file = new File(PATH);

            if (file.length() > 0) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                employeeList = (List<Employee>) ois.readObject();
                ois.close();
            }
        }
        catch (ClassNotFoundException | IOException e) {
           e.printStackTrace();
        }
    }
    @Override
    public void displayEmployee() {
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        writeObject(employeeList);
    }

    @Override
    public void editEmployee(int id) {
        boolean isExist = false;
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                isExist = true;
                System.out.println("Employee does exist !");
                System.out.println(e);

                System.out.print("Enter new ID : ");
                int idE = Integer.parseInt(sc.nextLine());
                System.out.print("Enter new name : ");
                String nameE = sc.nextLine();
                Employee employee = new Employee(idE, nameE);

                employeeList.set(employeeList.indexOf(e), employee);

            }
        }

        if (!isExist) {
            System.out.println("Employee does not exist !!!");
        }

        writeObject(employeeList);
    }

    public static void writeObject(List<Employee> employeeList) {
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeList);
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
