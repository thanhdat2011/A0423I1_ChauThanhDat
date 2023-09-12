package _16_IO_TextFile.Exercise.ReadFileCSV;

import java.io.*;

public class ReadFileCSV {
    public static void main(String[] args) {
        File file = new File("D:\\CodeGym\\module2\\src\\_16_IO_TextFile\\Exercise\\ReadFileCSV/NationalLists.csv");
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {

                String[] row = line.split(",");

                for (String e : row) {
                    System.out.printf("%-10s", e);
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
