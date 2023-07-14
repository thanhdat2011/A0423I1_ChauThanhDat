package _03_array_method.practice;

import java.util.Objects;
import java.util.Scanner;

public class p2_search_in_array {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] students = {"Dat","Hoai","Quan","Phong","Thang"};
        System.out.println("Search student's name");
        String name = sc.nextLine();

        boolean isExist = false;
        for (int i = 0 ; i < students.length; i ++) {
            if (students[i].equals(name)) {
                System.out.println(name + " in the position "+ i +" of the list");
                isExist = true;
                break;
            }
        }

        if (!isExist) System.out.println("NOT FOUND");
    }
}
