package _13_Search_Algorism.Exercise.AscendingString;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AscendingString {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter string : ");
        String str = sc.nextLine();

        LinkedList<Character> result = new LinkedList<>();
        result.add(str.charAt(0));

        for (int i=1; i < str.length(); i++) {
            if (str.charAt(i) > result.getLast()) {
                result.add(str.charAt(i));
            }
        }

        for (char e : result) {
            System.out.print(e);
        }
    }
}
