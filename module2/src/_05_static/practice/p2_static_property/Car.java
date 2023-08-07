package _05_static.practice.p2_static_property;

public class Car {
    private String model;
    private String color;
    static int numOfCars;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
        numOfCars++;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getNumOfCars() {
        return numOfCars;
    }

    public static void setNumOfCars(int numOfCars) {
        Car.numOfCars = numOfCars;
    }
}
