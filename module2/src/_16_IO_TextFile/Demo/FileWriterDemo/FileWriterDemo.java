package _16_IO_TextFile.Demo.FileWriterDemo;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("D:/CodeGym/module2/src/_16_IO_TextFile/Demo/FileWriterDemo/poem.txt");
            writer.write("Roses are red \nViolets are blue \nBooty booty booty booty \nRockin' everywhere!");
            writer.append("\n(A poem by Bro)");
            writer.close();

            // be sure close the file
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
