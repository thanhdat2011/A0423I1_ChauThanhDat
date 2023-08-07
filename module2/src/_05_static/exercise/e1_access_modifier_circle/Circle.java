package _05_static.exercise.e1_access_modifier_circle;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle () {
        this.radius = 1.0;
        this.color = "red";
    }
    public double getRadius() {                                 // Get radius
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

    public double getArea() {                                      // Get Area
        return Math.PI*Math.pow(radius,2);
    }
}

// change access modifier of getRadius() and getArea() ===> ERROR