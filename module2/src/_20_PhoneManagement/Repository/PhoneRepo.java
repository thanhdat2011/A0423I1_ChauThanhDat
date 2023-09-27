package _20_PhoneManagement.Repository;

import java.util.List;

public interface PhoneRepo<T> {
    void create(T t);
    List<T> display();
    boolean deleteById(int id);
    List<T> findByName(String name);
}
