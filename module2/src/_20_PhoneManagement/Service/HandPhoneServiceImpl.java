package _20_PhoneManagement.Service;

import _20_PhoneManagement.Model.HandPhone;
import _20_PhoneManagement.Repository.HandPhoneRepoIpl;
import _20_PhoneManagement.Repository.PhoneRepo;

import java.util.List;

public class HandPhoneServiceImpl implements HandPhoneService{
    PhoneRepo<HandPhone> repo = new HandPhoneRepoIpl();

    @Override
    public void create(HandPhone handPhone) {
        repo.create(handPhone);
    }

    @Override
    public List<HandPhone> display() {
        return repo.display();
    }

    @Override
    public boolean deleteById(int id) {
        return repo.deleteById(id);
    }

    @Override
    public List<HandPhone> findByName(String name) {
        return repo.findByName(name);
    }
}
