package _03_array_method.exercise;

import java.util.Scanner;

public class e2_insert_element_to_array {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        System.out.print("Enter size of the array : ");
        size = Integer.parseInt(sc.nextLine());
        System.out.println("Your array");
        int[] arr;
        arr = new int[size];
        for (int i=0; i<size; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int num, index;
        System.out.print("Input number to insert : ");
        num = Integer.parseInt(sc.nextLine());
        System.out.print("Insert to position of array : ");
        index = Integer.parseInt(sc.nextLine());

        if (index >= 0 && index < size) {
            // create new array -> insert num to new array
            int[] newArr;
            newArr = new int[size + 1];
            for (int i=0 ; i < newArr.length; i++) {
                if (i < index) {
                    newArr[i] = arr[i];
                } else if (i == index) {
                    newArr[i] = num;
                } else {
                    newArr[i] = arr[i-1];
                }
            }
            // display new array
            for (int j : newArr) {
                System.out.println(j);
            }
        } else {
            System.out.println("Invalid");
        }
    }


}
