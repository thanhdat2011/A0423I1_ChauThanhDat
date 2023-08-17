package _15_Debug.Exercise.IllegalTriangleException;

import java.util.Scanner;

public class Test_IllegalTriangleException {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Check triangle");
        System.out.print("Enter side a : ");
        int a = Integer.parseInt(scan.nextLine());
        System.out.print("Enter side b : ");
        int b = Integer.parseInt(scan.nextLine());
        System.out.print("Enter side c : ");
        int c = Integer.parseInt(scan.nextLine());
        try {
            checkTriangle(a,b,c);
        }
        catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
    }

    private static void checkTriangle(int a, int b, int c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0 || a+b <= c || a+c <= b || b+c <= a) {
            throw new IllegalTriangleException("\nHey! It is not triangle");
        } else
            System.out.printf("Alright! It is Triangle with sides respectively: %d, %d, %d", a,b,c);
    }
}
