package _00_Ex_Exam.Repository;

import _00_Ex_Exam.Model.Phone;

import java.util.List;

public interface PhoneRepo {
    void addP(Phone phone);
    List<Phone> displayP();
    boolean deleteById(int id);
    boolean deleteByName(String name);
    List<Phone> findByName(String name);
    List<Phone> findByPrice(double price);
    void editById(int id);
    void sortByPrice();
    void sortById();
}
