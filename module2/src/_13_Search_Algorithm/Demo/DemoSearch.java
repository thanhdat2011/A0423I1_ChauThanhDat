package _13_Search_Algorithm.Demo;

import _13_Search_Algorithm.Practice.BinarySearch_NoRecursion.BinarySearch;

import java.util.Arrays;

public class DemoSearch {
    public static void main(String[] args) {
        int[] numList = {15, 0, 20, 11, 30, 8};
        Arrays.sort(numList);
        int result = Arrays.binarySearch(numList,8);
        System.out.println(result);
        System.out.println(Arrays.toString(numList));
    }
}
