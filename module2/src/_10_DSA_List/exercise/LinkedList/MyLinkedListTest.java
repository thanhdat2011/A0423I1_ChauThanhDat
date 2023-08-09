package _10_DSA_List.exercise.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>("dat");

        System.out.print("-----------------\n FIRST LINKED LIST\n");
        linkedList.addFirst("bui");
        linkedList.addFirst("tuyen");
        linkedList.addFirst("duy");
        linkedList.addFirst("toan");
        linkedList.add(1,"minh");
        linkedList.add(1,"phuc");
        linkedList.addLast("NAM");
        linkedList.printList();
        System.out.println("SIZE = " + linkedList.size());

        System.out.print("-----------------\n REMOVE FIRST & LAST & 'tuyen' \n");
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove("tuyen");
        linkedList.printList();
        System.out.println("SIZE = " + linkedList.size());

        System.out.print("-----------------\n CHECK 'bui' & '10'\n");
        System.out.println(linkedList.contains("bui"));
        System.out.println(linkedList.contains("10"));

        System.out.print("-----------------\n INDEX OF\n");
        System.out.println("dat : " + linkedList.indexOf("dat"));
        System.out.println("duy : " + linkedList.indexOf("duy"));
        System.out.println("CHO : " +linkedList.indexOf("CHO"));

        System.out.print("----------------\n Get E of index\n");
        linkedList.printList();
        System.out.println("SIZE = " + linkedList.size());
        System.out.println("First : " + linkedList.getFirst());
        System.out.println("Last : " +linkedList.getLast());
        System.out.println("Index 3 : " + linkedList.get(3));

        System.out.print("--------------\n CLEAR LIST\n");
        linkedList.clear();
        //linkedList.addFirst("HEHEHE");
        linkedList.printList();
    }
}
