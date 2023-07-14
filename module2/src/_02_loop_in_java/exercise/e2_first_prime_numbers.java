package _02_loop_in_java.exercise;

import java.util.Scanner;

public class e2_first_prime_numbers {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Display prime number");
        int num, i=1, count = 0;
        System.out.print("How many first prime number you want to display ? ");
        num = sc.nextInt();
        do {
            i ++;
            if (isPrime(i)) {
                System.out.println(i);
                count ++;
            }
        } while (count < num);
    }

    public static boolean isPrime(int val) {
        for (int i = 2; i < val; i++) {
                if (val % i == 0) {
                    return false;
                }
        }
        return true;
    }
}
