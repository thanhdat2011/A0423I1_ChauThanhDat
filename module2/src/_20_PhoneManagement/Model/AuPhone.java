package _20_PhoneManagement.Model;

public class AuPhone extends PhoneBase{
    private int maintainByYear;
    private String maintainCode;

    public AuPhone(int id, String name, double price, String manufacture, int maintainByYear, String maintainCode) {
        super(id, name, price, manufacture);
        this.maintainByYear = maintainByYear;
        this.maintainCode = maintainCode;
    }

    public int getMaintainByYear() {
        return maintainByYear;
    }

    public void setMaintainByYear(int maintainByYear) {
        this.maintainByYear = maintainByYear;
    }

    public String getMaintainCode() {
        return maintainCode;
    }

    public void setMaintainCode(String maintainCode) {
        this.maintainCode = maintainCode;
    }

    @Override
    public String toString() {
        return "AuthenticPhone{" +
                "maintainByYear=" + maintainByYear +
                ", maintainCode='" + maintainCode + '\'' +
                '}' + super.toString();
    }
}
