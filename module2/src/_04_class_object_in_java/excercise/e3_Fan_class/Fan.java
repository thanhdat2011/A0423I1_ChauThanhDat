package _04_class_object_in_java.excercise.e3_Fan_class;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed;
    private boolean isOn;
    private double radius;
    private String color;

    Fan () {
        this.speed = SLOW;
        this.isOn = false;
        this.radius = 5;
        this.color = "blue";
    }
    Fan (int speed, double radius, String color, boolean isOn) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.isOn = isOn;
    }

    public int getSpeed() {                             // SPEED
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {                             // isON
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public double getRadius() {                         // RADIUS
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {                          // COLOR
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (isOn()) {
            return "Fan{" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    ", Fan is on" +
                    '}';
        } else {
            return "Fan{" +
                    "radius=" + radius +
                    ", color='" + color + '\'' +
                    ", Fan is off" +
                    '}';
        }
    }
}
