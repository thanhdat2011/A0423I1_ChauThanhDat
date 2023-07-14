package _01_introduction_to_java.practice;

import java.util.Scanner;

public class p5_count_date {
    public static void main(String[] args) {
        System.out.println("How many days in this month");
        System.out.println("Which month ?");
        int month;

        Scanner sc = new Scanner(System.in);
        month = sc.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + month + " có 31 ngày.");
                break;
            case 2:
                System.out.println("Tháng " + month + " có 28 hoặc 29 ngày.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + month + " có 30 ngày");
                break;
            default:
                System.out.println("Invalid input !!!");
        }

    }
}
