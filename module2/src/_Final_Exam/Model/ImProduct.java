package _Final_Exam.Model;

public class ImProduct extends  Product{
    private double imPrice;
    private String province;
    private double tax;

    public ImProduct(int id, String code, String name, double price, int amount, String manufacture, double imPrice, String province, double tax) {
        super(id, code, name, price, amount, manufacture);
        this.imPrice = imPrice;
        this.province = province;
        this.tax = tax;
    }

    public double getImPrice() {
        return imPrice;
    }

    public void setImPrice(double imPrice) {
        this.imPrice = imPrice;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return   super.toString() + " ImProduct{" +
                "imPrice=" + imPrice +
                ", province='" + province + '\'' +
                ", tax=" + tax +
                '}';
    }

    @Override
    public String toProduct() {
        return toString();
    }
}
