package _12_Java_Collection_Framework.Exercise.ProductManagement.Repository;

import _12_Java_Collection_Framework.Exercise.ProductManagement.Model.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class ProductRepoImpl implements ProductRepo{
    private static ArrayList<Product> productList;
    Scanner sc = new Scanner(System.in);
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Apple 14", "gold", 1000));
        productList.add(new Product(2,"Oppo", "purple",2000));
    }

    @Override
    public void findall() {
        for (Product e : productList) {
            System.out.println(e);
        }
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void updateProduct(int id) {
        for (Product e : productList) {
            if (e.getId() == id) {
                System.out.print("Enter name : ");
                String nameP = sc.nextLine();
                System.out.print("Enter color : ");
                String colorP = sc.nextLine();
                System.out.print("Enter price : ");
                int priceP = Integer.parseInt(sc.nextLine());
                Product product = new Product(id, nameP, colorP, priceP);
                productList.set(productList.indexOf(e), product);
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        for (Product e : productList) {
            if (e.getId() == id) {
                productList.remove(e);
            }
        }
    }

    @Override
    public void searchProduct(String name) {
        for (Product e : productList) {
            if (Objects.equals(e.getName(), name)) {
                System.out.println(e);
            }
        }
    }
}
