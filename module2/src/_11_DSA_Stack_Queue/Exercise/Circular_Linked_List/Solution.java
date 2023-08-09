package _11_DSA_Stack_Queue.Exercise.Circular_Linked_List;

public class Solution {
    public static void enQueue(Queue queue, int data) {
        Node temp = new Node();
        temp.data = data;
        if (queue.front == null) {
            queue.front = queue.rear = temp;
        } else {
            queue.rear.link = temp;
            queue.rear = temp;
        }
        queue.rear.link = queue.front;
    }
    public static int deQueue(Queue queue) {
        Node temp = queue.front;
        if (queue.front == null) {
            return -1;
        }
        if (queue.front == queue.rear) {
            queue.front = queue.rear = null;
        } else {
            queue.front = queue.front.link;
            queue.rear.link = queue.front;
        }
        return temp.data;
    }
    public static void displayQueue(Queue queue) {
        Node temp = queue.front;
        while (temp.link != queue.front) {
                System.out.println(temp.data);
                temp = temp.link;
        }
        System.out.println(temp.data);
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        enQueue(queue,1);
        enQueue(queue,2);
        enQueue(queue,3);
        enQueue(queue,4);
        enQueue(queue,5);
        enQueue(queue,6);
        deQueue(queue);
        deQueue(queue);
        deQueue(queue);
        displayQueue(queue);
    }
}
