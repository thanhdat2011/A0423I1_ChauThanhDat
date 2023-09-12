package _06_Inheritance.exercise.Circle_Cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        height = 1.0;
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVol() {
        return super.getArea() * height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * Math.pow(getRadius(),2) + 2 * Math.PI * getRadius() * height ;
    }

    @Override
    public double getPerimeter() {
        return 2 * (2 * getRadius() + height);
    }


    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}' +
                " which is subclass of " + super.toString();
    }
}
