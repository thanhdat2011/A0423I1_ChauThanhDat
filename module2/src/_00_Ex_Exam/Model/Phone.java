package _00_Ex_Exam.Model;

public class Phone {
    private int id;
    private String name;
    private double price;
    private String band;

    public Phone(int id, String name, double price, String band) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.band = band;
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

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", band='" + band + '\'' +
                '}';
    }
}
