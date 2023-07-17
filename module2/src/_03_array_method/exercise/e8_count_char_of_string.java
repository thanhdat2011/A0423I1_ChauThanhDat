package _03_array_method.exercise;

import java.util.Scanner;

    //    Hàm str.length() trả về tổng số ký tự trong một chuỗi str
    //    Hàm str.charAt(i) trả về ký tự ở vị trí thứ i trong chuỗi str
public class e8_count_char_of_string {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int count = 0;

        System.out.println("Enter string : ");
        String str = sc.nextLine();

        System.out.println("Enter a char which you want to count : ");
        char c = sc.next().charAt(0);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }

        System.out.println("Character '" + c + "' appears " + count + " time");
    }
}
