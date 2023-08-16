package _13_Search_Algorism.Exercise.BinarySearch_UsingRecursion;

import java.util.*;

public class BinarySearchRecursion {
    static Scanner sc = new Scanner(System.in);
    static int binarySearch(int[] arr, int left, int right, int value) {
        if (right >= left) {
            int mid = (left + right)/2 ;
            if (value < arr[mid]) {
                return binarySearch(arr, left, mid-1, value);
            }
            else if (value > arr[mid]) {
                return binarySearch(arr, mid+1, right, value);
            }
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.print("Enter size of array : ");
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];
        for (int i=0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.print("Enter searching value : ");
        int value = Integer.parseInt(sc.nextLine());
        System.out.println(binarySearch(arr, 0, size-1, value));
    }
}
