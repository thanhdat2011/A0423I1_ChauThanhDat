package _17_IO_BinaryFile.Practice.CopyFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class TestCopyFile {
    private final static String PATH = "D:/CodeGym/module2/src/_17_IO_BinaryFile/Practice/CopyFile";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter source file:");        // /source.txt
        String sourcePath = in.nextLine();
        System.out.println("Enter destination file:");   // /dest.txt
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            //copyFileUsingJava7Files(sourceFile, destFile);
            copyFileUsingStream(sourceFile, destFile);
            System.out.println("Copy completed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFileUsingJava7Files(File source, File dest) throws Exception {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source, File dest) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (is != null && os != null) {
                    is.close();
                    os.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
