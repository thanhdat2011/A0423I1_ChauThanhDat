package _Final_Exam.Repository;

import _Final_Exam.Model.ImProduct;

import java.util.List;
import java.util.function.Predicate;

public interface ProductRepository<T> {
    void add(T t);
    List<T> findAll();
    boolean deleteByCode(String code);
    List<T> findByNameOrCode(String field);
    List<T> search(Predicate<T> product);

}
