package _11_DSA_Stack_Queue.Practice.Optional.Stack_UsingArray;

public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(4);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }
}
