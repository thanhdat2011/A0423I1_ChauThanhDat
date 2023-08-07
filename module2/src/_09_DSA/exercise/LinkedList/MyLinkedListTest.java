package _09_DSA.exercise.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>("dat");

        System.out.print("-----------------\n FIRST LINKED LIST\n");
        linkedList.addFirst("bui");
        linkedList.addFirst("duy");
        linkedList.addFirst("toan");
        linkedList.add(1,"minh");
        linkedList.add(1,"phuc");
        linkedList.addLast("NAM");
        linkedList.printList();

        System.out.print("-----------------\n REMOVE INDEX 2\n");
        linkedList.remove(2);
        linkedList.printList();

        System.out.print("-----------------\n CHECK 'duy' & '10'\n");
        System.out.println(linkedList.contains("duy"));
        System.out.println(linkedList.contains("10"));

        System.out.print("-----------------\n INDEX OF\n");
        System.out.println("dat : " + linkedList.indexOf("dat"));
        System.out.println("toan : " + linkedList.indexOf("toan"));
        System.out.println("CHO : " +linkedList.indexOf("CHO"));

        System.out.print("----------------\n Get E of index\n");
        linkedList.printList();
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.get(3));

        System.out.print("--------------\n CLEAR LIST\n");
        linkedList.clear();
        //linkedList.addFirst("HEHEHE");
        linkedList.printList();
    }
}
