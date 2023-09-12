package _16_IO_TextFile.Demo.FileClassDemo;

import java.io.File;

public class FileClass {
    public static void main(String[] args) {

        // file = An abstract representation of file and directory pathname

        File file = new File("D:/CodeGym/module2/src/_16_IO_TextFile/Demo/FileClassDemo/secret_message.txt");

        if(file.exists()) {
            System.out.println("That file exists! :O!");
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.isFile());
            //file.delete();

        }
        else {
            System.out.println("That file doesn't exist :(");
        }
    }
}
