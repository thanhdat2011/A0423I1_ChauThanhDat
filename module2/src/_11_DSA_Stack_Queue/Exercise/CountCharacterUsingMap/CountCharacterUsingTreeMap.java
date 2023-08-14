package _11_DSA_Stack_Queue.Exercise.CountCharacterUsingMap;

import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.TreeMap;

public class CountCharacterUsingTreeMap {
    static Scanner sc = new Scanner(System.in);
    static final int DEFAULT_VALUE = 1;
    public static void main(String[] args) {
        System.out.println("Enter string : ");
        String str = sc.nextLine().replaceAll(" ","").toUpperCase();
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        char[] strings = str.toCharArray();
        System.out.println(Arrays.toString(strings));
        for (Character e : strings) {
           if (!treeMap.containsKey(e)) {
               treeMap.put(e, DEFAULT_VALUE);
           } else
               treeMap.put(e, treeMap.get(e) + 1);
        }

        System.out.println(treeMap);
    }
}
