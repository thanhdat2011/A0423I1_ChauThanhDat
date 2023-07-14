package _03_array_method.practice;

import java.util.Scanner;

public class p3_max_num_in_array {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int size;
        System.out.println("Enter size of the array");
        size = Integer.parseInt(sc.nextLine());
        int[] arr;
        arr = new int[size];
        System.out.println("Your array");
        for (int i=0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Display ar
        for (int i=0; i < size; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n");
        // find Max
        int max = arr[0];
        for (int i = 0 ; i < size ; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.print("MAX = " + max);
    }
}
