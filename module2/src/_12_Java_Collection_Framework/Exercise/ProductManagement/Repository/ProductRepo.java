package _12_Java_Collection_Framework.Exercise.ProductManagement.Repository;

import _12_Java_Collection_Framework.Exercise.ProductManagement.Model.Product;

public interface ProductRepo {
    void findall();
    void addProduct(Product product);
    void updateProduct(int id);
    void deleteProduct (int id);
    void searchProduct(String name);
    void arrangeAscendingProduct();
    void arrangeDecendingProduct();
}
