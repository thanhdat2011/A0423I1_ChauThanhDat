package _12_Java_Collection_Framework.Practice.SavingStudentList_UsingMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Dat", 23);
        hashMap.put("Truong", 19);
        hashMap.put("Quoc", 20);
        hashMap.put("Duy", 23);
        hashMap.put("Bui", 23);
        hashMap.put("Trung", 30);

        System.out.println(hashMap);

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap);

        //Map<String, Integer> linkedHashMap = new LinkedHashMap<>(treeMap);
        for (String e : treeMap.keySet()) {
            System.out.println("\nThe age for " + e + " is " + treeMap.get(e));
        }
    }
}
