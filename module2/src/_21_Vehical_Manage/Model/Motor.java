package _21_Vehical_Manage.Model;

public class Motor extends Vehical{
    private double load;

    public Motor(int id, String vehicalNum, int produceYear, String band, String owner, double load) {
        super(id, vehicalNum, produceYear, band, owner);
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "load=" + load +
                '}' + super.toString();
    }

    @Override
    public String toVehical() {
        return toString();
    }
}
