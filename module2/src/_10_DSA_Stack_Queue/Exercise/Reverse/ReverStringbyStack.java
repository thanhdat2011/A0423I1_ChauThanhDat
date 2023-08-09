package _10_DSA_Stack_Queue.Exercise.Reverse;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverStringbyStack {
    public static void main(String[] args) {
        String string;
        Scanner sc = new Scanner(System.in);
        string = sc.nextLine();

        char[] str = string.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char e: str) {
            stack.push(e);
        }

        for (int i=0; i<str.length; i++) {
            str[i] = stack.pop();
        }
        System.out.println(str);
    }
}
