package _21_Vehical_Manage.Service;

import _21_Vehical_Manage.Model.Motor;
import _21_Vehical_Manage.Repository.MotorRepoImpl;
import _21_Vehical_Manage.Repository.VehicalRepo;

import java.util.List;

public class MotorServiceImpl implements BaseService<Motor> {
    private final VehicalRepo<Motor> repo = new MotorRepoImpl();
    @Override
    public void add(Motor motor) {
        repo.add(motor);
    }

    @Override
    public List<Motor> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return repo.deleteById(id);
    }

    @Override
    public List<Motor> findByOwner(String name) {
        return repo.findByOwner(name);
    }

    @Override
    public void updateById(int id) {
        repo.updateById(id);
    }

    @Override
    public void sortByProduceYear() {
        repo.sortByProduceYear();
    }
}
