package _21_Vehical_Manage.Repository;

import java.util.List;

public interface VehicalRepo<T> {
    void add(T t);
    List<T> findAll();
    boolean deleteById(int id);
    List<T> findByOwner(String owner);
    void updateById(int id);
    void sortByProduceYear();
}
