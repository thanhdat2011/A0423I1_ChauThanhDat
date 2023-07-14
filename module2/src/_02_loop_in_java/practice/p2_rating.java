package _02_loop_in_java.practice;

import java.util.Scanner;

public class p2_rating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sending, totalInterest = 0.0;
        float rating;
        int month;
        System.out.println("Money you send ?");
        sending = sc.nextDouble();
        System.out.println("Rating (by year) ?");
        rating = sc.nextFloat();
        System.out.println("how many month ?");
        month = sc.nextInt();

//        for (int i=0; i<month; i++) {
            totalInterest += sending * (rating/100)/12 * month;
//        }

        System.out.println("Your money " + totalInterest);
    }
}
