package _12_Java_Collection_Framework.Demo;

import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new java.util.HashMap<>();
        map.put(0,"dat");
        map.put(1,"duy");
        map.put(2,"bui");
        map.put(3,"minh");
        System.out.println(map.remove(4));
        for (String k: map.values()) {
            System.out.println(k);
        }
    }
}
