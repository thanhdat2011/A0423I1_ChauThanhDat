package _14_Arrange_Algorithm.Practice;

public class InsertionSortSample {
    public static void main(String[] args) {
        int[] arr = {9, 1, 8, 2, 7, 3, 6, 5, 4};

        System.out.println("First Array");
        for (int i: arr) {
            System.out.print(i + " ");
        }

        insertionSort(arr);

        System.out.println("After insertion sort");
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        System.out.println("\nIn sorting process");
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
            for (int e: arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
