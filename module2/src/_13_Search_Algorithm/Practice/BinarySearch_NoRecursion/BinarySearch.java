package _13_Search_Algorithm.Practice.BinarySearch_NoRecursion;

import java.util.Arrays;

public class BinarySearch {
    static int[] list = {4,2,25,33,11,7,99,14,20,5};
    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1;     /* Now high < low, key not found */
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        System.out.println("------------------");
        System.out.println(binarySearch(list, 33));

    }
}
