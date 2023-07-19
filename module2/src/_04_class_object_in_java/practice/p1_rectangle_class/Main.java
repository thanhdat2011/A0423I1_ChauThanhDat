package _04_class_object_in_java.practice.p1_rectangle_class;

import _04_class_object_in_java.practice.Rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width");
        double width = sc.nextDouble();
        System.out.println("Enter height");
        double height = sc.nextDouble();
        Rectangle rec = new Rectangle(width, height);
        System.out.println("Your rectangle \n" + rec.display());
        System.out.println("Area = " + rec.getArea());
        System.out.println("Perimeter = " + rec.getPerimeter());
    }
}
