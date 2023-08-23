package _17_IO_BinaryFile.Demo.Object_InputOutput_Stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
    //public final static String PATH = "D:\\CodeGym\\module2\\src\\_17_IO_BinaryFile\\Demo\\Object_InputOutput_Stream";
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\CodeGym\\module2\\src\\_17_IO_BinaryFile\\Demo\\Object_InputOutput_Stream/product.txt"));
            Product product1 = new Product(1, "Iphone 15", 2000, "Deep Purple");
            oos.writeObject(product1);
            oos.flush();
//            Product product2 = new Product(2, "Nokia 2012", 1000, "Black");
//            oos.writeObject(product2 + "\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (oos != null) {
                oos.close();
            }
        }
        System.out.println("Success !!!");
    }

}
