package _16_IO_TextFile.Exercise.CopyFileText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFileText {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter filePath you want to copy : ");
        String filePathSource = sc.nextLine();

        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            File file = new File(filePathSource);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

//            File file = new File("D:\\CodeGym\\module2\\src\\_16_IO_TextFile\\Exercise\\CopyFileText\\e1_SourceFile.txt");
            br = new BufferedReader(new FileReader(file));

//            Enter target
            System.out.println("Enter filePath you want to copy to : ");
            String filePathTarget = sc.nextLine();

            FileWriter writer = new FileWriter(filePathTarget);

//            FileWriter writer = new FileWriter("D:\\CodeGym\\module2\\src\\_16_IO_TextFile\\Exercise\\CopyFileText\\e1_TargetFile.txt");
            bw = new BufferedWriter(writer);

            // ANOTHER WAY TO READ : READ BY CHARACTER
//            int data = br.read();
//            while (data != -1) {
//                System.out.print((char) data);
//                bw.write(data);
//                data = br.read();
//                }

            List<String> res = new ArrayList<>();

            // READ BY LINE
            String line = "";
            while ((line = br.readLine()) != null) {
                res.add(line);
            }

            for (String str : res) {
                bw.write(str + "\n");
            }

        }
        catch (FileNotFoundException e) {
            System.err.println("HEY! That file doesn't exist !!!");
        }
        catch (IOException e) {
            System.err.println("Something went wrong !!!");
        }
        finally {
            if (br != null && bw != null) {
                try {
                    br.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
