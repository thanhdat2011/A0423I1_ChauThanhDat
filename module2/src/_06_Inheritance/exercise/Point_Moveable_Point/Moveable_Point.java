package _06_Inheritance.exercise.Point_Moveable_Point;

public class Moveable_Point extends Point {
    private float xSpeed;
    private float ySpeed;

    public Moveable_Point() {
        xSpeed = 0.0f;
        ySpeed = 0.0f;
    }

    public Moveable_Point(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public Moveable_Point(float x, float y, float xSpeed, float ySpeed) {
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {
        float[] arr = {xSpeed, ySpeed};
        return arr;
    }
    public void move() {
        float a = getX();
        float b = getY();
        a += xSpeed;
        b += ySpeed;
        setXY(a,b);
    }
    @Override
    public String toString() {
        return  "Moveable_Point " +
                "(" + getX() + "," + getY() + ")" +
                ", speed = (" + xSpeed + "," + ySpeed + ")";
    }
}
