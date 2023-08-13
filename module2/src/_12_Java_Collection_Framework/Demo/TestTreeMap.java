package _12_Java_Collection_Framework.Demo;

import _12_Java_Collection_Framework.Practice.HashMap_HashSet.Student;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        Student student1 = new Student("dat",23,"son tra");
        Student student2 = new Student("bui",18,"my khe");
        Student student3 = new Student("duy",21,"hoa vang");
        Student student4 = new Student("toan",15,"hai chau");
        Map<Student, Integer> map = new TreeMap<>();
        map.put(student1, 10);
        map.put(student2, 7);
        map.put(student3, 9);
        map.put(student4, 5);
    }
}
