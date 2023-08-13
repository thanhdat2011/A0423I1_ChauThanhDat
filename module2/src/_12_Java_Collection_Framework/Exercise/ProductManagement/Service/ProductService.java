package _12_Java_Collection_Framework.Exercise.ProductManagement.Service;

import _12_Java_Collection_Framework.Exercise.ProductManagement.Model.Product;

public interface ProductService {
    void findall();
    void addProduct(Product product);
    void updateProduct(int id);
    void deleteProduct (int id);
    void searchProduct(String name);
}
