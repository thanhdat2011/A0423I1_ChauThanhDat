package _12_Java_Collection_Framework.Exercise.ProductManagement.Controller;

import _12_Java_Collection_Framework.Exercise.ProductManagement.Model.Product;
import _12_Java_Collection_Framework.Exercise.ProductManagement.Service.ProductService;
import _12_Java_Collection_Framework.Exercise.ProductManagement.Service.ProductServiceImpl;

import java.util.Scanner;

public class ProductController {
    private static ProductService productService = new ProductServiceImpl();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select = 0;
        do {
            System.out.printf("%n");
            System.out.println("----------PRODUCT MANAGER-----------");
            System.out.println("1. List");
            System.out.println("2. Add product");
            System.out.println("3. Update product (by id)");
            System.out.println("4. Delete product (by id)");
            System.out.println("5. Search product (by name)");
            System.out.println("6. Sort product by ascending (by price)");
            System.out.println("7. Sort product by descending (by price)");
            System.out.print("Your selecting : ");
            select = Integer.parseInt(sc.nextLine());
            System.out.printf("%n");
            switch (select) {
                case 1: productService.findAll();
                    break;
                case 2:
                    System.out.print("Enter id : ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter color : ");
                    String color = sc.nextLine();
                    System.out.print("Enter price : ");
                    int price = Integer.parseInt(sc.nextLine());
                    Product product = new Product(id, name, color, price);
                    productService.addProduct(product);
                    break;
                case 3:
                    System.out.print ("Which id of product want to update : ");
                    int input = Integer.parseInt(sc.nextLine());
                    productService.updateProduct(input);
                    break;
                case 4:
                    System.out.print ("Which id of product want to delete : ");
                    int input1 = Integer.parseInt(sc.nextLine());
                    productService.deleteProduct(input1);
                    break;
                case 5:
                    System.out.print ("Search product (by name) : ");
                    String input2 = sc.nextLine();
                    productService.searchProduct(input2);
                    break;
                case 6:
                    System.out.println("Sort product by ascending (by price)");
                    productService.arrangeAscendingProduct();
                    break;
                case 7 :
                    System.out.println("Sort product by descending (by price)");
                    productService.arrangeDecendingProduct();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("INVALID SELECT");
            }
        } while (true);

    }
}
