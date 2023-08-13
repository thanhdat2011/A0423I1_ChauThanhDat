package _12_Java_Collection_Framework.Practice.HashMap_HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Dat",23,"Son Tra");
        Student student2 = new Student("Duy",18,"Hoa Vang");
        Student student3 = new Student("Bui",21,"My Khe");
        Student student4 = new Student("Toan",20,"Hai Chau");
        Map<Student, Integer> studentMap = new HashMap<>();
        studentMap.put(student1, 10);
        studentMap.put(student2, 7);
        studentMap.put(student3, 8);
        studentMap.put(student4, 5);
        for (Student key : studentMap.keySet()) {
            System.out.println(key + " - " + studentMap.get(key));
        }

        System.out.println("--------------------------");

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        studentSet.add(student4);
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
}
