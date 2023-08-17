package _15_Debug.Demo.Checked_Unchecked_Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckException {
    public static void main(String[] args) {

        readFile("myFile.txt");
    }

    private static void readFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
        }
        catch (FileNotFoundException fnfe) {
            //System.err.println("Hey! That file does not exist !");
            fnfe.printStackTrace();
        }
    }

//    private static void readFile(String fileName) throws FileNotFoundException {
//            FileReader reader = new FileReader(fileName);
//    }
//
//    You can write 'readFile()' like this then using 'try-catch' block in main

//    CheckException that Java make you deal with one way and another at compiler time that means that before
//    your program will even compile successfully Java check to ensure that you're dealing with the
//    possibility of that exception happening and it's won't compiler until you do
}
