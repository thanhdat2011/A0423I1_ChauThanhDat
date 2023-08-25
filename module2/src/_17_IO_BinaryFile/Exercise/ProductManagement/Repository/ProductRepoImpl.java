package _17_IO_BinaryFile.Exercise.ProductManagement.Repository;

import _17_IO_BinaryFile.Exercise.ProductManagement.Model.Product;

import java.io.*;
import java.util.*;

public class ProductRepoImpl implements ProductRepo {
    private static Scanner sc = new Scanner(System.in);
    private final static String PATH = "D:\\CodeGym\\module2\\src\\_17_IO_BinaryFile\\Exercise\\ProductManagement\\Data\\productData";
    private List<Product> data = new ArrayList<>();
    private ObjectOutputStream oos;


    public ProductRepoImpl() {
        try {
            File file = new File(PATH);

            if (file.length() > 0) {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(PATH));
                data = (List<Product>) input.readObject();
            }
//            else {
//                oos = new ObjectOutputStream(new FileOutputStream(PATH));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAll() {
        if (data.size() > 0) {
            for (Product p : data) {
                System.out.println(p);
            }
        } else
            System.out.println("No product to show");
    }

    @Override
    public void addProduct(Product product) {

        data.add(product);
        System.out.println("Add successful !!!");

        writeToFile(data);
    }

    @Override
    public void searchProduct(String name) {

        List<Product> temp = new ArrayList<>();

        for (Product e : data) {
            if (Objects.equals(e.getName(), name)) {
                temp.add(e);
            }
        }

        for (Product p : temp) {
            System.out.println(p);
        }
    }

    @Override
    public void deleteProduct(int id) {
        data.removeIf(p -> p.getId() == id);
        System.out.println("Done delete product having ID :  " + id );

        writeToFile(data);
    }

    @Override
    public void sortById() {
        Collections.sort(data, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getId() - o2.getId();
            }
        });
        System.out.println("Done sort by Id");

        writeToFile(data);
    }

    @Override
    public void updateProduct(int id) {
        for (Product p : data) {
            if (p.getId() == id) {
                System.out.println("Product do exists !");
                System.out.println(p);

                System.out.print("Enter new id : ");
                int idP = Integer.parseInt(sc.nextLine());

                System.out.print("Enter new name : ");
                String nameP = sc.nextLine();

                System.out.print("Enter new color : ");
                String colorP = sc.nextLine();

                System.out.print("Enter new price : ");
                int priceP = Integer.parseInt(sc.nextLine());

                Product product = new Product(idP, nameP, colorP, priceP);
                data.set(data.indexOf(p), product);

                writeToFile(data);
            }
            else {
                System.out.println("ID doesn't exist !!!");
                break;
            }
        }
    }

    public void writeToFile(List<Product> products) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(products);

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
