package _03_array_method.exercise;

import java.util.Scanner;

public class e3_merge_array {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Merge array");

        // array 1
        System.out.print("Enter size of array 1 : ");
        int size1;
        size1 = Integer.parseInt(sc.nextLine());
        System.out.println("Array 1 : ");
        int[] arr1;
        arr1 = new int[size1];
        for (int i=0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(sc.nextLine());
        }

        // array 2
        System.out.print("Enter size of array 2 : ");
        int size2;
        size2 = Integer.parseInt(sc.nextLine());
        System.out.println("Array 2 : ");
        int[] arr2;
        arr2 = new int[size2];
        for (int i=0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(sc.nextLine());
        }

        // merge array 1 2 -> array 3
        int[] arr3;
        arr3 = new int[size1 + size2];
        for (int i=0; i < arr3.length; i++) {
            if (i < arr1.length) {
                arr3[i] = arr1[i];
            } else {
                arr3[i] = arr2[i - arr1.length];
            }
        }

        // display array 3
        System.out.println("Array 3 : ");
        for (int j : arr3) {
            System.out.print(j + "\t");
        }
    }
}
