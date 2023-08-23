package _17_IO_BinaryFile.Demo.Object_InputOutput_Stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {
    public static void main(String args[]) throws Exception {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\CodeGym\\module2\\src\\_17_IO_BinaryFile\\Demo\\Object_InputOutput_Stream/product.txt"));
            Product product = (Product) ois.readObject();
            System.out.println(product);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
    }
}
