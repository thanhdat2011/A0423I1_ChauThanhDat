package _20_PhoneManagement.Model;

public abstract class PhoneBase {
    private int id;
    private String name;
    private double price;
    private String manufacture;

    public PhoneBase(int id, String name, double price, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "PhoneBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
    public void ring(){
        System.out.println("reng");
    }
}
