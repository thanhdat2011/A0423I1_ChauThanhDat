package _03_array_method.practice;

import java.util.Scanner;

public class p6_count_pass_student {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Programing count passed student");
        int size;

        do {
            System.out.print("Enter the size of list student (MAX 30) : ");
            size = Integer.parseInt(sc.nextLine());
            if (size > 30) System.out.println("MAX size is 30");
        } while (size > 30);

        float[] list;
        list = new float[size];
        System.out.println("Enter mark of "+ size + " students");

        int countPass = 0;
        int countList = 0;
        float mark;

        while (countList < size) {
            mark = sc.nextFloat();
            if (mark >= 0 && mark <= 10) {
                list[countList] = mark;
                countList++;
            } else {
                System.out.println("Invalid mark");
            }
        };

        System.out.println("List of student's mark");
        for (float element:list) {
            System.out.print(" | " + element + " | ");
            if (element > 5.0) {
                countPass++;
            }
        }
        System.out.println();
        System.out.println("The number of student who passed : " + countPass);

    }

}
