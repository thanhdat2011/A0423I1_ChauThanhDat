package _21_Vehical_Manage.Model;

import java.io.*;

public class Truck extends Vehical{
    private double wattage;

    public Truck(int id, String vehicalNum, int produceYear, String band, String owner, double wattage) {
        super(id, vehicalNum, produceYear, band, owner);
        this.wattage = wattage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "wattage=" + wattage +
                '}' + super.toString();
    }

    @Override
    public String toVehical() {
        return toString();
    }

}
