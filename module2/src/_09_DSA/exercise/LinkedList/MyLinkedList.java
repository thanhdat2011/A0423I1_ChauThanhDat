package _09_DSA.exercise.LinkedList;

import _06_Inheritance.exercise.Point_Moveable_Point.Point;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;
    public MyLinkedList(Object data) {
       head = new Node(data);
       numNodes++;
    }
    class Node {
        private Node next;
        private Object data;
        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return data;
        }
    }
    public int size() {
        return numNodes;
    }
    public void add(int index,E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        Node holder;
        for (int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(E e) {
        Node holder;
        holder = head;
        head = new Node(e);
        head.next = holder;
        numNodes++;
    }
    public void addLast(E e) {
        Node holder;
        holder = head;
        while (holder.next != null) {
            holder = holder.next;
        }
        holder.next = new Node(e);
        numNodes++;
    }
    public E remove(int index) {                          // 0      1     2     3     4
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E) current.data;
        }
    }
    public void remove(E e) {                        //0     1       2       3       4
        Node previous = head;
        if (head.data.equals(e)) removeFirst();
        else
            for (int i=0; i<size()-2;i++) {
                if (previous.next.data.equals(e)) {
                    Node current = previous.next;
                    previous.next = current.next;
                }
                previous = previous.next;
            }
        numNodes--;
    }
    public void removeFirst() {
        head = head.next;
        numNodes--;
    }
    public void removeLast() {
        Node temp = head;
        for (int i=0; i<size()-2;i++) {
            temp = temp.next;
        }
        temp.next = null;
        numNodes--;
    }
    public boolean contains(E e) {
        Node temp = head;
        while(temp != null) {
            if (temp.data.equals(e)) {
                return true;
            } else
                temp = temp.next;
        }
        return false;
    }
    public int indexOf(E e) {
        Node temp = head;
        if (temp != null) {
            for (int i=0; i<numNodes;i++) {
                if (temp.data.equals(e)) {
                    return i;
                }
                temp = temp.next;
            }
        }
        return -1;
    }
    public E get(int index) {
        Node temp = head;
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }
        for (int i=0; i<index;i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
    public E getFirst() {
        if (head != null) {
            return (E) head.data;
        }
        return null;
    }
    public E getLast() {                    //0     1       2       3       4
        Node temp = head;
        if (temp.next == null) getFirst();
        else for (int i=0; i<numNodes-1;i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
    public void clear() {
        head = null;
        numNodes = 0;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.printf("%n");
    }
}
