package _21_Vehical_Manage.Model;

public class Car extends Vehical{
    private int seat;
    private String form;

    public Car(int id, String vehicalNum, int produceYear, String band, String owner, int seat, String form) {
        super(id, vehicalNum, produceYear, band, owner);
        this.seat = seat;
        this.form = form;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

//    @Override
//    public String toVehical() {
//        return String.format("%s,%s,%s,%s,%s,%s,%s", getId(), getVehicalNum(), getProduceYear(), getBand(), getOwner(), getSeat(), getForm());
//    }

    @Override
    public String toString() {
        return "Car{" +
                "seat=" + seat +
                ", form='" + form + '\'' +
                '}' + super.toString();
    }

    @Override
    public String toVehical() {
        return toString();
    }
}
