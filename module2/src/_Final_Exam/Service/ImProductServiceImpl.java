package _Final_Exam.Service;

import _Final_Exam.Model.ImProduct;
import _Final_Exam.Repository.ImProductRepoImpl;
import _Final_Exam.Repository.ProductRepository;

import java.util.List;
import java.util.function.Predicate;

public class ImProductServiceImpl implements ProductService<ImProduct>{
    ProductRepository<ImProduct> repo = new ImProductRepoImpl();

    @Override
    public void add(ImProduct imProduct) {
        repo.add(imProduct);
    }

    @Override
    public List<ImProduct> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean deleteByCode(String code) {
        return repo.deleteByCode(code);
    }

    @Override
    public List<ImProduct> findByNameOrCode(String field) {
        return repo.findByNameOrCode(field);
    }

    @Override
    public List<ImProduct> search(Predicate<ImProduct> product) {
        return repo.search(product);
    }
}
