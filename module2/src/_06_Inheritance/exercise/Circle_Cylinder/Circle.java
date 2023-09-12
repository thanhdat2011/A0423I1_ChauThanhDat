package _06_Inheritance.exercise.Circle_Cylinder;

public class Circle {
    private double radius;
    private String color;
    public Circle() {
        radius = 1.0;
        color = "yellow";
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

//    public void sayHello() {
//        System.out.println("hello");
//    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
