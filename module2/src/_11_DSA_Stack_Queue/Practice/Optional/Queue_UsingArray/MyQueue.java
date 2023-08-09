package _11_DSA_Stack_Queue.Practice.Optional.Queue_UsingArray;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head = 0;
    private int tail = -1;
    private int currentSize;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[capacity];
    }
    public boolean isQueueFull() {
        return currentSize == capacity;
    }
    public boolean isQueueEmpty() {
        return currentSize == 0;
    }
    public void enqueue(int data) {
        if (isQueueFull()) System.out.println("FULL");
        else {
            tail++;
            if (tail == capacity-1) tail=0;
            queueArr[tail] = data;
            currentSize++;
            System.out.println(data + " is pushed");
        }
    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Nothing to delete");
        } else {
            head++;
            if (head == capacity - 1) {
                System.out.println("Pop operation dun ! removed: " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }
}
