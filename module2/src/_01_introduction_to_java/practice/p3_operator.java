package _01_introduction_to_java.practice;

import java.util.Scanner;

//Viết một ứng dụng để tính diện tích của hình chữ nhật dựa vào chiều rộng và chiều cao được nhập vào.
public class p3_operator {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width :");
        width = sc.nextFloat();
        System.out.println("Enter height :");
        height = sc.nextFloat();
        float area = width * height;
        System.out.println("Area = " + area);
    }
}
