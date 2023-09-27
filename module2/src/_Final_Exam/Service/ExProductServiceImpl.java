package _Final_Exam.Service;

import _Final_Exam.Model.ExProduct;
import _Final_Exam.Repository.ExProductRepoImpl;
import _Final_Exam.Repository.ProductRepository;

import java.util.List;
import java.util.function.Predicate;

public class ExProductServiceImpl implements ProductService<ExProduct>{
    ProductRepository<ExProduct> repo = new ExProductRepoImpl();
    @Override
    public void add(ExProduct exProduct) {
        repo.add(exProduct);
    }

    @Override
    public List<ExProduct> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean deleteByCode(String code) {
        return repo.deleteByCode(code);
    }

    @Override
    public List<ExProduct> findByNameOrCode(String field) {
        return repo.findByNameOrCode(field);
    }

    @Override
    public List<ExProduct> search(Predicate<ExProduct> product) {
        return repo.search(product);
    }
}
