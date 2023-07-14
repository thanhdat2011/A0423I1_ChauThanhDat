package _03_array_method.practice;

import java.util.Scanner;

public class p5_min_num_in_array {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        System.out.print("Enter size of the array : ");
        size = Integer.parseInt(sc.nextLine());
        int[] arr;
        arr = new int[size];

        System.out.println("Your array");
        for (int i=0; i < size; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("MIN = "+ arr[find_min(arr)]);
    }

    public static int find_min(int[] array) {
        int min_odd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[min_odd]) {
                min_odd = i;
            }
        }
        return min_odd;
    }

}
