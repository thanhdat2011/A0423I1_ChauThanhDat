package _Final_Exam.Model;

public class ExProduct extends Product{
    private double exPrice;
    private String nation;

    public ExProduct(int id, String code, String name, double price, int amount, String manufacture, double exPrice, String nation) {
        super(id, code, name, price, amount, manufacture);
        this.exPrice = exPrice;
        this.nation = nation;
    }

    public double getExPrice() {
        return exPrice;
    }

    public void setExPrice(double exPrice) {
        this.exPrice = exPrice;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return  super.toString() + " ExProduct{" +
                "exPrice=" + exPrice +
                ", nation='" + nation + '\'' +
                '}';
    }

    @Override
    public String toProduct() {
        return toString();
    }
}
