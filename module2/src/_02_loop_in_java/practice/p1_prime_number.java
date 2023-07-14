package _02_loop_in_java.practice;

import java.util.Scanner;

public class p1_prime_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number");
        int a;
        a = Integer.parseUnsignedInt(sc.nextLine());
//        if (isPrime(a)) {
//            System.out.println(a + " is prime");
//        } else System.out.println(a + " is not prime");


        if (a < 2) {
            System.out.println(a + " is not prime");
        } else {
            boolean check = true;
            for (int i = 2; i < Math.sqrt(a); i++) {
                if (a % i == 0) {
                    check = false;
                    break;
              }
          }
            if (check) System.out.println(a + " is prime");
            else System.out.println(a + " is not prime");
        }
    }

//    public static boolean isPrime(int a) {
//        for (int i = 2; i < Math.sqrt(a); i++) {
//            if (a % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
