package _17_IO_BinaryFile.Exercise.ProductManagement.Repository;

import _17_IO_BinaryFile.Exercise.ProductManagement.Model.Product;

import java.io.IOException;
import java.util.ArrayList;


public interface ProductRepo {
    void findAll();
    void addProduct(Product product);
    void searchProduct(String name);
    void deleteProduct(int id);
    void sortById();
    void updateProduct(int id);
}
