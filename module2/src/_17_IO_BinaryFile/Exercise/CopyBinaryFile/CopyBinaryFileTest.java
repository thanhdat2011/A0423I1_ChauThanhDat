package _17_IO_BinaryFile.Exercise.CopyBinaryFile;

import java.io.*;
import java.util.List;

public class CopyBinaryFileTest {

    // data of product management exercise
    private static final String SOURCE_PATH = "D:\\CodeGym\\module2\\src\\_17_IO_BinaryFile\\Exercise\\ProductManagement\\Data\\productData";
    private static final String TARGET_PATH = "D:\\CodeGym\\module2\\src\\_17_IO_BinaryFile\\Exercise\\CopyBinaryFile\\copyBinaryFile";
    public static void main(String[] args) {
        try {
            copyBinaryFile();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyBinaryFile() throws IOException {
        FileInputStream fis = new FileInputStream(SOURCE_PATH);
        FileOutputStream fos = new FileOutputStream(TARGET_PATH);

        byte[] bytes = new byte[1024];

        while ((fis.read(bytes)) > 0) {
            fos.write(bytes);
        }

        fis.close();
        fos.close();

        System.out.println("DONE COPY");
    }

}
