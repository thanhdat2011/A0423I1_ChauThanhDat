package _11_DSA_Stack_Queue.Exercise.Optional.Round_Bracket_UsingStack;

import java.util.Scanner;
import java.util.Stack;

public class RoundBracket {
    static Scanner sc = new Scanner(System.in);
    public static boolean checkRoundBracket(String string) {
        char[] strings = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character e : strings) {
            if (e == '(') {
                stack.push(e);
            }
            if (e == ')') {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void check(String string) {
        if (checkRoundBracket(string)) System.out.println(string+"\nWELL\n");
        else System.out.println(string+"\nNOT WELL\n");

    }
    public static void main(String[] args) {
        String str1 = "s * (s – a) * (s – b) * (s – c)";
        String str2 = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        String str3 = "s * (s – a) * (s – b * (s – c)";
        String str4 = "s * (s – a) * s – b) * (s – c)";
        String str5 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        check(str1);
        check(str2);
        check(str3);
        check(str4);
        check(str5);
    }
}
