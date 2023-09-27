package _21_Vehical_Manage.Service;

import _21_Vehical_Manage.Model.Car;
import _21_Vehical_Manage.Repository.CarRepoImpl;
import _21_Vehical_Manage.Repository.VehicalRepo;

import java.util.List;

public class CarServiceImpl implements BaseService<Car>{
    private final VehicalRepo<Car> repo = new CarRepoImpl();
    @Override
    public void add(Car car) {
        repo.add(car);
    }

    @Override
    public List<Car> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return repo.deleteById(id);
    }

    @Override
    public List<Car> findByOwner(String name) {
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
