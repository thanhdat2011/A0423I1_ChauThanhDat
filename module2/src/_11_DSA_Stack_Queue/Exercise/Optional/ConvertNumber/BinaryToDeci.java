package _11_DSA_Stack_Queue.Exercise.Optional.ConvertNumber;

import java.util.Scanner;
import java.util.Stack;

public class BinaryToDeci {
    static Scanner sc = new Scanner(System.in);
    public static boolean isBinary(int[] binary) {
        for (int e : binary) {
            if (e != 0 && e != 1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int size;
        System.out.print("Size of binary : ");
        size = Integer.parseInt(sc.nextLine());
        int[] binary = new int[size];
        System.out.println("Input Binary (1 digit / time) : ");
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<size;i++) {
            binary[i] = stack.push(Integer.parseInt(sc.nextLine()));
        }
        System.out.println(stack);
        int decimal = 0;
        int placeValue = 0;
        while (placeValue < size) {
            decimal += (int) Math.pow(2, placeValue) * stack.pop();
            placeValue++;
        }
        if (isBinary(binary)) System.out.println(decimal);
        else System.out.println("It is not binary");
    }
}
