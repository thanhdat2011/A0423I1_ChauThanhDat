package test;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    private static ProductService productService = new ProductService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true){
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Description: ");
            String des = scanner.nextLine();

            Product product = new Product(0, name, brand, price, des);
            productService.add(product);
//        productService.save(product);
            System.out.printf("Add new product %s successful\n", name);
        }
    }
}
