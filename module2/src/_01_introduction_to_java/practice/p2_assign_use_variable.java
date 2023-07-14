package _01_introduction_to_java.practice;

//    Số nguyên : byte (1 byte), short (2 bytes), int (4 bytes), long (8bytes)
//    Số thực : float (4 bytes), double (8 bytes)
//    Logic : bolean
//    kí tự : char (2 bytes)

//    Biến i kiểu số nguyên, có giá trị là 10
//    Biến f kiểu số thực, có giá trị là 20.5
//    Biến d kiểu số thực lớn, có giá trị là 20.5
//    Biến b kiểu logic, có giá trị là true
//    Biến c kiểu ký tự, có giá trị là 'a'
//    Biến s kiểu chuỗi, có giá trị là "Hà Nội".

public class p2_assign_use_variable {
    public static void main(String[] args) {
        int i = 10;
        long l = 100L;
        float f = 20.5f;
        double d = 20.5d;
        boolean b = true;
        char c = 'a';
        String s = "Hà nội";

        System.out.println("i = " + i);
        System.out.println("l = " + l);
        System.out.println("f = " + f);
        System.out.println("d = " + d);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("string = " + s);
    }
}
