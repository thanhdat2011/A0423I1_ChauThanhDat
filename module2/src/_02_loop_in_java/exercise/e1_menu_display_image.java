package _02_loop_in_java.exercise;

import java.util.Scanner;

public class e1_menu_display_image {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle (bot-left)");
        System.out.println("3. Print the square triangle (top-left)");
        System.out.println("4. Print the square triangle (bot-right)");
        System.out.println("5. Print the square triangle (top-right)");
        System.out.println("6. Print the isosceles triangle");
        System.out.println("0. Exit");
        int choice;
        do {
            System.out.print("\n");
            System.out.print("Your choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    rectangle();
                    break;
                case 2:
                    triangle_bot_left();
                    break;
                case 3:
                    triangle_top_left();
                    break;
                case 4:
                    triangle_bot_right();
                    break;
                case 5:
                    triangle_top_right();
                    break;
                case 6:
                    isosceles_triangle();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (true);

    }

    public static void rectangle() {

        System.out.println("Display Rectangle");
        int length, width;
        System.out.print("Input length : ");
        length = sc.nextInt();
        System.out.print("Input width : ");
        width = sc.nextInt();
        for (int i = 0; i < width; i++) {
            for (int j=0; j<length; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void triangle_bot_left() {
        System.out.println("Display triangle (bot-left) ");
        int height;
        System.out.print("Input height : ");
        height = sc.nextInt();
        for (int i = 0 ; i < height; i++) {
            for (int j = 0 ; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void triangle_top_left() {
        System.out.println("Display triangle (top-left) ");
        int height;
        System.out.print("Input height : ");
        height = sc.nextInt();
        for (int i = 0 ; i < height; i++) {
            for (int j = 0 ; j < height - i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void triangle_bot_right() {
        System.out.println("Display triangle (bot_right)");
        int height;
        System.out.print("Input height : ");
        height = sc.nextInt();
        for (int i = height; i > 0; i --) {
            for (int j = 1; j <= height ; j++) {
                if (j < i) System.out.print("  ");
                else System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void triangle_top_right() {
        System.out.println("Display triangle (top_right)");
        int height;
        System.out.print("Input height : ");
        height = sc.nextInt();
        for (int i = height; i > 0; i--) {
            for (int j = height ; j > 0 ; j--) {
                if (j <= i) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.print("\n");
        }
    }

    public static void isosceles_triangle() {
        System.out.println("Display isosceles triangle");
        int height;
        System.out.print("Input height : ");
        height = sc.nextInt();
        for (int i = height; i > 0; i --) {
            for (int j = 1; j <= height ; j++) {
                if (j < i) System.out.print("  ");
                else System.out.print("* ");
            }
            if (i < height) {
                for (int k = i; k < height  ; k++) {
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
    }

}
