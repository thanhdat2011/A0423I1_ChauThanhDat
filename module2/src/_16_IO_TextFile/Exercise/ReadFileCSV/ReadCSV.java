package _16_IO_TextFile.Exercise.ReadFileCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    private final static String FILE_PATH = "D:\\CodeGym\\module2\\src\\_16_IO_TextFile\\Exercise\\ReadFileCSV\\NationalLists.csv";
    public static void main(String[] args) throws IOException {
        List<Nation> nationList = readCSV();
        for (Nation e : nationList) {
            System.out.println(e);
        }

        //writeCSV(new Nation(10, "VN", "VietNam"));
    }
    public static List<Nation> readCSV() throws IOException {
        List<Nation> nations = new ArrayList<>();
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while ((line = br.readLine()) != null) {

            String[] row = line.split(",");

            int id = Integer.parseInt(row[0]);
            String standard = row[1];
            String name = row[2];

            Nation nation = new Nation(id, standard, name);
            nations.add(nation);
        }
        br.close();
        return nations;
    }

    public static void  writeCSV(Nation nation) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write(nation.getId() + "," + nation.getStandard() + "," + nation.getName() + "\n");
        bw.close();
    }

}
