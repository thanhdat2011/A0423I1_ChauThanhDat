package _03_array_method.practice;

import java.util.Scanner;

public class p1_reversed_array {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr;
        int size;
        do {
            System.out.println("Enter the size of array");
            size = Integer.parseInt(sc.nextLine());
            if (size > 20) System.out.println("Max 20");
        } while (size > 20);

        arr = new int[size];
        System.out.println("Your arr");
        for (int i = 0 ; i < size; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }
//        for (int i = 0 ; i < size; i++){
//            System.out.println(arr[i]);
//        }

        for (int i=0; i < size/2; i++){
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }

        System.out.println("Array after reversed");
        for (int i=0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }


}
