package _17_IO_BinaryFile.Demo.Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample2 {
    public static void main(String[] args) throws IOException {

        // Tạo một luồng đầu vào bằng cách đọc một file
        InputStream in = new FileInputStream("D:\\CodeGym\\module2\\src\\_16_IO_TextFile\\Exercise\\CopyFileText\\e1_SourceFile.txt");

        // Mảng để mỗi lần đọc các byte từ luồng thì tạm thời để lên đó
        // Ta dùng mảng 1024 byte

        byte[] bytes = new byte[1024];
        int i = -1;

        // Đọc các byte trong luồng và gán lên các phần tử của mảng.
        // Giá trị i là số đọc được của 1 lần. (i sẽ <= 1024).
        // Khi không còn phần tử trong luồng i sẽ = -1
        while ((i = in.read(bytes)) != -1) {
            // Tạo String từ các byte đọc được
            String s = new String(bytes, 0, i);
            System.out.println(s);
        }
        in.close();
    }
}
