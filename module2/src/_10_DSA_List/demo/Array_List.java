package _10_DSA_List.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_List {
    public static void main(String[] args) {
        List<Object> arrayList1 = new ArrayList<>();
        List<Object> arrayList2 = new ArrayList<>();
        arrayList2.add("Minh");
        arrayList2.add("Phuc");

        arrayList1.add("Dat");
        arrayList1.add("Duy");
        arrayList1.add("Bui");
        arrayList1.add(20);
        arrayList1.add(11);
//        for (int i=0; i<arrayList1.size(); i++) {
//            System.out.println(arrayList1.get(i));
//        }
        System.out.println(Arrays.toString(arrayList1.toArray()));
        System.out.println(arrayList1.get(1));
        System.out.println(arrayList1.contains(20));
        ////arrayList1.addAll(2, arrayList2);
        System.out.println(Arrays.toString(arrayList1.toArray()));
        //System.out.println(arrayList1.containsAll(arrayList2));
        arrayList1.remove("20");
        arrayList1.set(1, "Toan");
        System.out.println(arrayList1.isEmpty());
        System.out.println(Arrays.toString(arrayList1.toArray()));
        System.out.println(arrayList1.size());
        System.out.println("--------------------- \n List2");
        System.out.println(Arrays.toString(arrayList2.toArray()));
        arrayList2.clear();
        System.out.println(Arrays.toString(arrayList2.toArray()));
    }
}
