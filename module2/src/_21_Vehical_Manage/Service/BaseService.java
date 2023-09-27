package _21_Vehical_Manage.Service;

import java.util.List;

public interface BaseService<T> {
    void add(T t);
    List<T> findAll();
    boolean deleteById(int id);
    List<T> findByOwner(String name);
    void updateById(int id);
    void sortByProduceYear();
}
