package _20_PhoneManagement.Service;

import _20_PhoneManagement.Model.AuPhone;
import _20_PhoneManagement.Repository.AuPhoneRepoImpl;
import _20_PhoneManagement.Repository.PhoneRepo;

import java.util.List;

public class AuPhoneServiceImpl implements AuPhoneService{
    PhoneRepo<AuPhone> repo = new AuPhoneRepoImpl();
    @Override
    public void create(AuPhone auPhone) {
        repo.create(auPhone);
    }

    @Override
    public List<AuPhone> display() {
        return repo.display();
    }

    @Override
    public boolean deleteById(int id) {
        return repo.deleteById(id);
    }

    @Override
    public List<AuPhone> findByName(String name) {
        return repo.findByName(name);
    }
}
