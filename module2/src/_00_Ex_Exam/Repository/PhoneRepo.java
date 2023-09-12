package _00_Ex_Exam.Repository;

import _00_Ex_Exam.Model.Phone;

public interface PhoneRepo {
    void addP(Phone phone);
    void displayP();
    void deleteP(int id);
    void findP(String name);
}
