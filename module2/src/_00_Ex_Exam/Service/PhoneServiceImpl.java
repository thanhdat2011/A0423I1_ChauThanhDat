package _00_Ex_Exam.Service;

import _00_Ex_Exam.Model.Phone;
import _00_Ex_Exam.Repository.PhoneRepo;
import _00_Ex_Exam.Repository.PhoneRepoImpl;
import _00_Ex_Exam.Util.Validation;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    PhoneRepo repo = new PhoneRepoImpl();
    @Override
    public void addP(Phone phone) {
        repo.addP(phone);
    }

    @Override
    public List<Phone> displayP() {
        return repo.displayP();
    }

    @Override
    public boolean deleteById(int id) {
        return repo.deleteById(id);
    }

    @Override
    public boolean deleteByName(String name) {
        return repo.deleteByName(name);
    }

    @Override
    public List<Phone> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Phone> findByPrice(double price) {
        return repo.findByPrice(price);
    }

    @Override
    public void editById(int id) {
        repo.editById(id);
    }

    @Override
    public void sortByPrice() {
        repo.sortByPrice();
    }

    @Override
    public void sortById() {
        repo.sortById();
    }
}
