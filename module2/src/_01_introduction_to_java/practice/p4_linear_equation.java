package _01_introduction_to_java.practice;

import java.util.Scanner;

//  Viết chương trình LinearEquationResolver cho phép tìm ra nghiệm của một phương trình bậc nhất từ các hệ số do người dùng nhập vào.
//  ax + b = c
public class p4_linear_equation {
    public static void main(String[] args) {
        System.out.println("Giải phương trình bậc 1 có dạng ax + b = c");
        System.out.println("Nhập hệ số a , b , c");
        float a,b,c,x;

        Scanner sc = new Scanner(System.in);
        System.out.println("a = ");
        a = sc.nextFloat();
        System.out.println("b = ");
        b = sc.nextFloat();
        System.out.println("c = ");
        c = sc.nextFloat();

        if (a != 0) {
            x = (c - b) / a;
            System.out.println("x = " + x);
        } else {
            if (b == c) {
                System.out.println("Phương trình vô số nghiệm");
            } else
                System.out.println("Phương trình vô nghiệm");
        }

    }
}
