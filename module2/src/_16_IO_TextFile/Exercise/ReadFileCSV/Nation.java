package _16_IO_TextFile.Exercise.ReadFileCSV;

public class Nation {
    private int id;
    private String standard;
    private String name;

    public Nation() {
    }

    public Nation(int id, String standard, String name) {
        this.id = id;
        this.standard = standard;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "id=" + id +
                ", standard='" + standard + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
