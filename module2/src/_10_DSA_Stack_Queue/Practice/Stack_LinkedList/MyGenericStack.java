package _10_DSA_Stack_Queue.Practice.Stack_LinkedList;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;
    public MyGenericStack() {
        stack = new LinkedList<>();
    }
    public void push(T e) {
        stack.addLast(e);
    }
    public T pop () {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.removeLast();
    }
    public int size() {
        return stack.size();
    }
    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
