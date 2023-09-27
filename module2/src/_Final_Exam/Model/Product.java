package _Final_Exam.Model;

public abstract class Product {
    private int id;
    private String code;
    private String name;
    private double price;
    private int amount;
    private String manufacture;

    public Product(int id, String code, String name, double price, int amount, String manufacture) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
    public abstract String toProduct();
}
