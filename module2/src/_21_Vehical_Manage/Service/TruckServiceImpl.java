package _21_Vehical_Manage.Service;

import _21_Vehical_Manage.Model.Truck;
import _21_Vehical_Manage.Repository.TruckRepoImpl;
import _21_Vehical_Manage.Repository.VehicalRepo;

import java.util.List;

public class TruckServiceImpl implements BaseService<Truck> {
    private final VehicalRepo<Truck> repo = new TruckRepoImpl();
    @Override
    public void add(Truck truck) {
        repo.add(truck);
    }

    @Override
    public List<Truck> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return repo.deleteById(id);
    }

    @Override
    public List<Truck> findByOwner(String name) {
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
