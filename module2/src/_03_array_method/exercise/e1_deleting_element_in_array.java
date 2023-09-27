package _03_array_method.exercise;

import _00_Ex_Exam.Helper.Helper;

import java.util.Scanner;

public class e1_deleting_element_in_array {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int size;
        System.out.print("Enter size of array : ");
        size = Integer.parseInt(sc.nextLine());
        System.out.println("Your array");
        int[] arr;
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.print("Input Delete Number : ");
        int num = Integer.parseInt(sc.nextLine());
        int index = 0;
        boolean isExist = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                System.out.println(num + " is exist");
                isExist = true;
                index = i;
            }
        }
        //

        if (!isExist) {
            System.out.println(num + " is not exist");
        } else {
            // tao 1 mang moi sau khi xoa co (length - 1) -> coppy qua mang moi
            int[] newArr;
            newArr = new int[size - 1];
            for (int i = 0; i < newArr.length; i++) {
                if (i < index) {
                    newArr[i] = arr[i];
                } else {
                    newArr[i] = arr[i + 1];
                }
            }
            System.out.println("Array after delete num");
            for (int i = 0; i < newArr.length; i++) {
                System.out.println(newArr[i]);
            }
        }
    }

}
