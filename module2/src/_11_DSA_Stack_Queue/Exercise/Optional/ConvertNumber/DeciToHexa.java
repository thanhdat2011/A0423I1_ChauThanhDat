package _11_DSA_Stack_Queue.Exercise.Optional.ConvertNumber;

import java.util.*;

public class DeciToHexa {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num;
        System.out.print("Input Decimal : ");
        num = Integer.parseInt(sc.nextLine());
        Stack<Object> stack = new Stack<>();
        while (num != 0) {
            int remainder = num % 16;
            if (remainder > 9) {
                stack.push((char) (remainder-10+65));
                continue;
            }
            stack.push(remainder);
            num = num / 16;
        }
        System.out.println(stack);
    }
}
