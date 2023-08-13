package _12_Java_Collection_Framework.Practice.Comparable_Comparator;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("dat",23,"Son Tra");
        Student student2 = new Student("duy",18,"hoa vang");
        Student student3 = new Student("bui",21,"my khe");
        Student student4 = new Student("toan",17,"hai chau");

        Map<Student, Integer> lists = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        lists.put(student1,10);
        lists.put(student2,2);
        lists.put(student3,7);
        lists.put(student4,6);

        for (Student key : lists.keySet()) {
            System.out.println(key + " - " + lists.get(key));
        }
    }
}
