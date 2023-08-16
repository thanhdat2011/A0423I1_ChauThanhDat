package _14_Arrange_Algorithm.Practice;

public class SelectionSortSample {
    public static void main(String[] args) {
        int[] arr = {9, 1, 8, 2, 7, 3, 6, 5, 4};

        System.out.println("First Array");
        for (int i: arr) {
            System.out.print(i + " ");
        }

        selectionSort(arr);

        System.out.println("After selection sort");
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        System.out.println("\nIn sorting process");
        for (int i=0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            for (int e: arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
