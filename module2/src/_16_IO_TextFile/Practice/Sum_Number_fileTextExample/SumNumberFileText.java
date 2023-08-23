package _16_IO_TextFile.Practice.Sum_Number_fileTextExample;

import java.io.*;
import java.util.Scanner;

public class SumNumberFileText {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file path : ");
        String path = scan.nextLine();
        SumNumberFileText sumNumberFileText = new SumNumberFileText();
        sumNumberFileText.readFileText(path);
    }

    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            //br.close();

            System.out.println("Sum = " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
