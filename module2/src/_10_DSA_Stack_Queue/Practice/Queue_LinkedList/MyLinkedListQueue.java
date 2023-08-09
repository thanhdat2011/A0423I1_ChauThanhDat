package _10_DSA_Stack_Queue.Practice.Queue_LinkedList;

import java.util.Queue;

public class MyLinkedListQueue {
    Node head;
    Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }
    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
        }
        this.tail.next = temp;
        this.tail = temp;
    }
    public Node dequeue() {
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }

    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(15);
        queue.enqueue(9);
        queue.enqueue(20);
        queue.enqueue(11);
        queue.enqueue(2000);
        while (queue.head != null) {
            System.out.println(queue.dequeue().key);
        }
    }
}
