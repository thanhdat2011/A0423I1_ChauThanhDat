package _03_array_method.exercise;

import java.util.Scanner;

public class e7_sum_diagonal_square_matrix {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Display Square Matrix(rank n)");
        int n;
        System.out.print("Enter n : ");
        n = Integer.parseInt(sc.nextLine());
        double[][] arr;
        arr = new double[n][n];
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                arr[i][j] = (double) (Math.round(Math.random()*100))/10;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Sum of diagonal of square matrix = " + sum_diagonal_matrix(arr, n));
    }

     static double sum_diagonal_matrix(double [][]arr, int n) {
        double sum = 0;
        for (int i =0; i < n; i++) {
            for (int j=0; j < n; j++) {
                if (i==j) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

}
