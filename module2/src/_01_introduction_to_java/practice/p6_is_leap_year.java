package _01_introduction_to_java.practice;

import java.util.Scanner;

//        Những năm chia hết cho 4 mà không chia hết cho 100 là năm nhuận
//
//        Những năm chia hết cho 100 mà không chia hết cho 400 thì KHÔNG PHẢI là năm nhuận
//
//        Những năm chia hết đồng thời cho 100 và 400 là năm nhuận
public class p6_is_leap_year {
    public static void main(String[] args) {
        System.out.println("Kiểm tra năm nhuận");
        System.out.println("Which year ?");
        int year;

        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();

        boolean isLeapYear = false;
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.printf("%d is a leap year", year);
        } else {
            System.out.printf("%d is NOT a leap year", year);
        }

    }
}
