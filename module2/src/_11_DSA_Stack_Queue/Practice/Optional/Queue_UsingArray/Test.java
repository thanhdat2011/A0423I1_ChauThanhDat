package _11_DSA_Stack_Queue.Practice.Optional.Queue_UsingArray;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
