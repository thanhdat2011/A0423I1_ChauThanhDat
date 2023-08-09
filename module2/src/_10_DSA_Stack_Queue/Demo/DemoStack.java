package _10_DSA_Stack_Queue.Demo;

import java.util.LinkedList;
import java.util.Stack;

public class DemoStack {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.push("1");
        stack.push("duy");
        stack.push("3");
        stack.push("dat");
        stack.push("5");
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.empty());
        System.out.println(stack.peek());
        System.out.println(stack.search("duy"));
        System.out.println(stack.search("dat"));
    }
}
