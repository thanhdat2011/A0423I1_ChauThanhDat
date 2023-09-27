package _21_Vehical_Manage.Model;

public abstract class Vehical {
    private int id;
    private String vehicalNum;
    private int produceYear;
    private String band;
    private String owner;

    public Vehical(int id, String vehicalNum, int produceYear, String band, String owner) {
        this.id = id;
        this.vehicalNum = vehicalNum;
        this.produceYear = produceYear;
        this.band = band;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicalNum() {
        return vehicalNum;
    }

    public void setVehicalNum(String vehicalNum) {
        this.vehicalNum = vehicalNum;
    }

    public int getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(int produceYear) {
        this.produceYear = produceYear;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehical{" +
                "id=" + id +
                ", vehicalNum='" + vehicalNum + '\'' +
                ", produceYear=" + produceYear +
                ", band='" + band + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
    public abstract String toVehical();
}
