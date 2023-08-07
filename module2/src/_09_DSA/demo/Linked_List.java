package _09_DSA.demo;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

public class Linked_List {
    public static void main(String[] args) {
        List<Object> linkedList1 = new LinkedList<>();
        List<Object> linkedList2 = new LinkedList<>();
        linkedList2.add("Minh");
        linkedList2.add("Phuc");

        linkedList1.add("Dat");
        linkedList1.add("Duy");
        linkedList1.add("Bui");
        linkedList1.add(20);
        linkedList1.add(11);

        System.out.println(linkedList1);
        System.out.println();
        System.out.println(linkedList1.get(1));
        System.out.println(linkedList1.contains(20));
        ////arrayList1.addAll(2, arrayList2);

        System.out.println(linkedList1);
        //System.out.println(arrayList1.containsAll(arrayList2));
        linkedList1.remove("20");
        linkedList1.set(1, "Toan");
        System.out.println(linkedList1.isEmpty());

        System.out.println(linkedList1);
        System.out.println(linkedList1.size());
        System.out.println("--------------------- \n List2");

        System.out.println(linkedList1);
        linkedList2.clear();
        System.out.println(linkedList1);
    }
}
