package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class e1_greeting {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("What your name ?");
        String name = sc.nextLine();
        System.out.println("Hi " + name);

    }
}
