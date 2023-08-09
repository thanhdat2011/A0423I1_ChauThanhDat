package _10_DSA_Stack_Queue.Exercise.Reverse;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Stack;

public class ReverseIntergerArrayByStack {
    public static void main(String[] args) {
        int[] array;
        array = new int[10];
        for (int i=0; i<array.length; i++) {
            array[i] = (int) Math.round(Math.random()*10);
        }
        System.out.println("Array");
        System.out.println(Arrays.toString(array));
        Stack<Integer> integerStack = new Stack<>();
        for (int e : array) {
            integerStack.push(e);
        }
        System.out.println("COPPY TO STACK");
        System.out.println(integerStack);
        System.out.println("ARRAY AFTER REVERSE");
        for (int i=0; i<array.length; i++) {
            array[i] = integerStack.pop();
        }
        System.out.println(Arrays.toString(array));

    }
}
