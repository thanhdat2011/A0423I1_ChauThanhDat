package _12_Java_Collection_Framework.Exercise.ProductManagement.Service;

import _12_Java_Collection_Framework.Exercise.ProductManagement.Model.Product;
import _12_Java_Collection_Framework.Exercise.ProductManagement.Repository.ProductRepo;
import _12_Java_Collection_Framework.Exercise.ProductManagement.Repository.ProductRepoImpl;

public class ProductServiceImpl implements ProductService{
    private ProductRepo repo = new ProductRepoImpl();
        @Override
        public void findAll() {
            repo.findall();
        }

        @Override
        public void addProduct(Product product) {
            repo.addProduct(product);
        }

        @Override
        public void updateProduct(int id) {
            repo.updateProduct(id);
        }

        @Override
        public void deleteProduct(int id) {
            repo.deleteProduct(id);
        }

        @Override
        public void searchProduct(String name) {
            repo.searchProduct(name);
        }

        @Override
        public void arrangeAscendingProduct() {
            repo.arrangeAscendingProduct();
        }
        @Override
        public void arrangeDecendingProduct() {
            repo.arrangeDecendingProduct();
        }
}
