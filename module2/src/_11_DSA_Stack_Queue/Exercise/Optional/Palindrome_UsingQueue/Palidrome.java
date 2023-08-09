package _11_DSA_Stack_Queue.Exercise.Optional.Palindrome_UsingQueue;

import java.util.*;

public class Palidrome {
    static Scanner sc = new Scanner(System.in);
    public static boolean isPalidrome(Stack stack, Queue queue) {
        for (int i=0; i < stack.size()/2; i++) {
            if (stack.pop() != queue.remove()) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.print("Enter String : ");
        String str = sc.nextLine();
        char[] string = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char e : string) {
            stack.push(e);
        }

        Queue<Character> queue = new LinkedList<>();
        for (char e : string) {
            queue.add(e);
        }

        if (isPalidrome(stack, queue)) {
            System.out.println(str + " is Palidrome.");
        } else System.out.println(str + " is not Palidrome");
    }
}
