package _11_DSA_Stack_Queue.Practice.Optional.Stack_UsingArray;

public class MyStack {
    private int[] array;
    private int size;
    private int index;

    public MyStack(int size) {
        this.size = size;
        array = new int[size];
    }
    public void push(int element){
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        array[index] = element;
        index++;
    }
    public int pop() {
        return array[--index];
    }
    public int size() {
        return size;
    }
    public boolean isFull(){
        return index == size;
    }
    public boolean isEmpty(){
        return index == 0;
    }
}
