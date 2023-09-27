package _20_PhoneManagement.Service;

import java.util.List;

public interface BaseService<T> {
    void create(T t);
    List<T> display();
    boolean deleteById(int id);
    List<T> findByName(String name);
}
