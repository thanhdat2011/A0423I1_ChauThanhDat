package _Final_Exam.Service;

import java.util.List;
import java.util.function.Predicate;

public interface ProductService<T> {
    void add(T t);
    List<T> findAll();
    boolean deleteByCode(String code);
    List<T> findByNameOrCode(String field);
    List<T> search(Predicate<T> product);
}
