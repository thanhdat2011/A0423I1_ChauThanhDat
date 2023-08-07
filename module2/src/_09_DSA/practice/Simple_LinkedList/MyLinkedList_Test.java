package _09_DSA.practice.Simple_LinkedList;

public class MyLinkedList_Test {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList("dat");
        linkedList.addFirst(10);
        linkedList.addFirst(5);
        linkedList.addFirst(99);
        linkedList.add(2,"duy");
        linkedList.printList();

    }
}
