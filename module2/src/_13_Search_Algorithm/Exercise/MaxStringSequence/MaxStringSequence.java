package _13_Search_Algorithm.Exercise.MaxStringSequence;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxStringSequence {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Enter String : ");
        String string = sc.nextLine();

        LinkedList<Character> result = new LinkedList<>();

        for (int i = 0; i < string.length(); i++) {

            LinkedList<Character> temp = new LinkedList<>();
            temp.add(string.charAt(i));

            // add substring to temp
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > temp.getLast()) {
                    temp.add(string.charAt(j));
                } else break;
            }

            // temp > result -> replace (find max substring sequence)
            if (temp.size() > result.size()) {
                result.clear();
                result.addAll(temp);
            }

            // clear to add new substring
            temp.clear();
        }

        for (Character e: result) {
            System.out.print(e);
        }
    }
}
