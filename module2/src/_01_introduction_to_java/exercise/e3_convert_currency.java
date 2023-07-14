package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class e3_convert_currency {
    public static void main(String[] args) {
        double vnd, usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input USD : ");
        usd = Integer.parseUnsignedInt(sc.nextLine());
        vnd = usd * 25000;
        System.out.println(usd + " USD = " + vnd + " USD");
    }
}
