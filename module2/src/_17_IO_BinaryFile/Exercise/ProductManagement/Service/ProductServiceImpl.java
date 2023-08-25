package _17_IO_BinaryFile.Exercise.ProductManagement.Service;

import _17_IO_BinaryFile.Exercise.ProductManagement.Model.Product;
import _17_IO_BinaryFile.Exercise.ProductManagement.Repository.ProductRepo;
import _17_IO_BinaryFile.Exercise.ProductManagement.Repository.ProductRepoImpl;

import java.io.IOException;
import java.util.ArrayList;


public class ProductServiceImpl implements ProductService{
    private ProductRepo repo = new ProductRepoImpl();

    @Override
    public void findAll(){
        repo.findAll();
    }

    @Override
    public void addProduct(Product product){
        repo.addProduct(product);
    }

    @Override
    public void searchProduct(String name){
        repo.searchProduct(name);
    }

    @Override
    public void deleteProduct(int id) {
        repo.deleteProduct(id);
    }

    @Override
    public void sortById() {
        repo.sortById();
    }

    @Override
    public void updateProduct(int id) {
        repo.updateProduct(id);
    }
}
