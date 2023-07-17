package _03_array_method.exercise;

import java.util.Scanner;

public class e6_sum_numbers_in_specific_collum {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Display 2D matrix (m x n)");
        int m,n;
        System.out.print("Input m : ");
        m = Integer.parseInt(sc.nextLine());
        System.out.print("Input n : ");
        n = Integer.parseInt(sc.nextLine());
        int [][] arr;
        arr = new int[m][n];
        for (int i = 0 ; i < m; i++) {
            for (int j=0; j < n; j++) {
                arr[i][j] = (int) (Math.random()*10);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("\n");
        }

        int a;
        System.out.println("Sum all of which collum ?(first col is 0)");
        a = Integer.parseInt(sc.nextLine());
        System.out.println("Sum of collum " + a + " = " + sum_in_collum(arr, m, n, a));
    }

    static  int sum_in_collum(int[][]arr,int m, int n, int a) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a == j) {
                    sum += arr[i][a];
                }
            }
        }
        return sum;
    }

}
