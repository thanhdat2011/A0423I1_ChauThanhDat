package _16_IO_TextFile.Demo.FileReaderDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("D:/CodeGym/module2/src/_16_IO_TextFile/Demo/FileReaderDemo/art.txt");
            int data = reader.read();

            while (data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
