package _04_class_object_in_java.excercise.e1_Quadratic_Equation_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a :");
        double a = Integer.parseInt(sc.nextLine());
        System.out.print("Enter b :");
        double b = Integer.parseInt(sc.nextLine());
        System.out.print("Enter c :");
        double c = Integer.parseInt(sc.nextLine());

        // tao doi tuong equation1
        Quadratic_Equation equation1 = new Quadratic_Equation(a, b, c);

        // display results
        if (equation1.getDiscriminant() > 0) {
            System.out.println("The equation has 2 roots : " + equation1.getRoot1() + " and " + equation1.getRoot2());
        } else if (equation1.getDiscriminant() == 0) {
            System.out.println("The equation has 1 root : " + equation1.getRoot1());
        } else System.out.println("The equation has no real roots");

    }

}
