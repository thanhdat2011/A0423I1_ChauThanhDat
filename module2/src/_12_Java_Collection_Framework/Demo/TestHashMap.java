package _12_Java_Collection_Framework.Demo;

import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new java.util.HashMap<>();
        map.put(0,"dat");
        map.put(1,"duy");
        map.put(2,"bui");
        map.put(3,"minh");

//        System.out.println(map.remove(4));

//        for (String e: map.values()) {
//            System.out.println(e);
//        }

//        for (Integer key : map.keySet()) {
//            System.out.println("KEY : " + key + " VALUE : " + map.get(key));
//        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("dat"));
    }
}
