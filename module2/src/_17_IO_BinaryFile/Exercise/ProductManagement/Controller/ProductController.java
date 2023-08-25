package _17_IO_BinaryFile.Exercise.ProductManagement.Controller;

import _17_IO_BinaryFile.Exercise.ProductManagement.Model.Product;
import _17_IO_BinaryFile.Exercise.ProductManagement.Service.ProductService;
import _17_IO_BinaryFile.Exercise.ProductManagement.Service.ProductServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    private static ProductService productService = new ProductServiceImpl();
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("---------MENU----------");
            System.out.println("1. Display Product");
            System.out.println("2. Add Product");
            System.out.println("3. Update Product");
            System.out.println("4. Search Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Sort Product (By id)");

            System.out.print("Your choice : ");
            int select = Integer.parseInt(sc.nextLine());

            switch (select) {
                case 1:
                    productService.findAll();
                    break;
                case 2:
                    System.out.print("Enter id of product : ");
                    int idP = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter name of product : ");
                    String nameP = sc.nextLine();
                    System.out.print("Enter color of product : ");
                    String colorP = sc.nextLine();
                    System.out.print("Enter price of product : ");
                    int priceP = Integer.parseInt(sc.nextLine());
                    Product product = new Product(idP, nameP, colorP, priceP);
                    productService.addProduct(product);
                    break;
                case 3:
                    System.out.print("Enter id of product you want to update");
                    int id3 = Integer.parseInt(sc.nextLine());
                    productService.updateProduct(id3);
                    break;
                case 4:
                    System.out.print("Enter name of product you want to search : ");
                    String nameS = sc.nextLine();
                    productService.searchProduct(nameS);
                    break;
                case 5:
                    System.out.print("Enter ID of product you want to delete : ");
                    int id5 = Integer.parseInt(sc.nextLine());
                    productService.deleteProduct(id5);
                    break;
                case 6:
                    productService.sortById();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("INVALID CHOICE");
            }

        } while (true);
    }

}
