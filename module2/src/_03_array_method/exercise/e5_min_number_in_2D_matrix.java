package _03_array_method.exercise;

import java.util.Scanner;

public class e5_min_number_in_2D_matrix {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Display 2D matrix (m x n)");
        System.out.print("Input m : ");
        int m;
        m = Integer.parseInt(sc.nextLine());
        System.out.print("Input n : ");
        int n;
        n = Integer.parseInt(sc.nextLine());

        System.out.println("Your matrix");
        double [][] arr;
        arr = new double[m][n];
        // 2D Matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (double) (Math.round(Math.random()*10000))/100;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("\n");
        }

        // method findMin
        findMin(arr);
    }

    public static void  findMin(double arr[][]) {
        double min = arr[0][0];
        int m=0;
        int n=0;
        for (int i=0; i < arr.length;i++) {
            for (int j=0; j < arr.length; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    m = i;
                    n = j;
                }
            }
        }
        System.out.print("MIN = " + min + " at position " + (m+1) + ";" + (n+1));
    }
}
