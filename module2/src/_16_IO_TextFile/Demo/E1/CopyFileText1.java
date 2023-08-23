//package _16_IO_TextFile.Demo.E1;
//
//import java.io.*;
//
//public class CopyFileText1 {
//    //static final String PATH= "src\\_16_io_text_file\\exercise\\e1";
//
//    public static void main(String[] args) {
//        String source= "D:\\CodeGym\\module2\\src\\_16_IO_TextFile\\Exercise\\CopyFileText\\e1_SourceFile.txt";
//        String des= "D:\\CodeGym\\module2\\src\\_16_IO_TextFile\\Exercise\\CopyFileText\\e1_TargetFile.txt";
//        try {
//            copyFile(source, des);
//            writeNumberCharacter(des);
//        } catch (IOException ioException) {
//            System.out.println(ioException.getMessage());
//        }
//    }
//
//    private static void copyFile(String source,String des) throws IOException{
//        FileInputStream sourceFile = new FileInputStream(source);
//        FileOutputStream destFile = new FileOutputStream(des);
//        byte[] array = new byte[1024];
//        sourceFile.read(array);
//        destFile.write(array);
//        sourceFile.close();
//        destFile.close();
//    }
//
//    private static void writeNumberCharacter(String path) throws IOException{
//        File file= new File(path);
//        if(!file.canRead())
//            file.setReadable(true);
//        BufferedReader bufferedReader= new BufferedReader(new FileReader(file));
//        String line;
//        String tmp= "";
//        while ((line= bufferedReader.readLine())!= null) {
//            tmp += line;
//        }
//        bufferedReader.close();
//
//        int res = tmp.replace(" ", "").length();
//        System.out.println(res);
//
//        // java 11 have method Files.writeString, Files.readString
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
//        bufferedWriter.write("\nTotal character in file: "+ res);
//        bufferedWriter.close();
//    }
//}