package _14_Arrange_Algorithm.Exercise;

public class BubbleSortSample {
    public static void main(String[] args) {
        int[] arr = {9, 1, 8, 2, 7, 3, 6, 5, 4};

        System.out.println("First array");
        for (int i: arr) {
            System.out.print(i + " ");
        }

        bubbleSort(arr);

        System.out.println("After bubble sort");
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    private static void bubbleSort(int[] arr) {
        System.out.println("\nIn sorting process");
        for (int i=0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

                // Print each step of process
                for (int e : arr) {
                    System.out.print(e + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
