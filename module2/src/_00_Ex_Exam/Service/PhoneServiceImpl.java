package _00_Ex_Exam.Service;

import _00_Ex_Exam.Model.Phone;
import _00_Ex_Exam.Repository.PhoneRepo;
import _00_Ex_Exam.Repository.PhoneRepoImpl;

public class PhoneServiceImpl implements PhoneService {
    PhoneRepo repo = new PhoneRepoImpl();
    @Override
    public void addP(Phone phone) {
        repo.addP(phone);
    }

    @Override
    public void displayP() {
        repo.displayP();
    }

    @Override
    public void deleteP(int id) {
        repo.deleteP(id);
    }

    @Override
    public void findP(String name) {
        repo.findP(name);
    }
}
