package _20_PhoneManagement.Model;

public class HandPhone extends PhoneBase{
    private String nation;
    private String status;

    public HandPhone(int id, String name, double price, String manufacture, String nation, String status) {
        super(id, name, price, manufacture);
        this.nation = nation;
        this.status = status;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HandPhone{" +
                "nation='" + nation + '\'' +
                ", status='" + status + '\'' +
                '}' + super.toString();
    }

    @Override
    public void ring() {
        super.ring();
    }
}
