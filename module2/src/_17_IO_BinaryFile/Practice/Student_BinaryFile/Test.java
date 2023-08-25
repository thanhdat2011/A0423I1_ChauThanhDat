package _17_IO_BinaryFile.Practice.Student_BinaryFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public final static String PATH = "D:\\CodeGym\\module2\\src\\_17_IO_BinaryFile\\Practice\\Student_BinaryFile";
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"dat","son tra"));
        students.add(new Student(2,"duy","hoa vang"));
        students.add(new Student(3,"bui","my khe"));
        students.add(new Student(4,"minh","hai chau"));
        writeToFile(PATH + "/students.txt", students);
        List<Student> studentDataFromFile = readDataFromFile(PATH + "/students.txt");
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
//            oos.close();
//            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(path);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            students = (List<Student>) ois.readObject();
            ois.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

}
