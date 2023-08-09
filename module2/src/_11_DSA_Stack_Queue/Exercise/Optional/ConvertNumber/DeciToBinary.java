package _11_DSA_Stack_Queue.Exercise.Optional.ConvertNumber;

import java.util.Scanner;
import java.util.Stack;

public class DeciToBinary {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int size = 0;
        int num;
        System.out.print("Input Decimal : ");
        num = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            int remainder = num % 2;
            stack.push(remainder);
            num = num / 2;
            size++;
        }
        int[] binary = new int[size];
        for (int i=0; i<size; i++) {
            binary[i] = stack.pop();
        }
        System.out.print("Convert to Binary : ");
        for (int i=0; i<size; i++) {
            System.out.print(binary[i]);
        }
    }

}
