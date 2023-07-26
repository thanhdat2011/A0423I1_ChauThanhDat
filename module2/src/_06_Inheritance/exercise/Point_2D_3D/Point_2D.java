package _06_Inheritance.exercise.Point_2D_3D;

public class Point_2D {
    private float x;
    private float y;
    public Point_2D() {
        x = 0.0f;
        y = 0.0f;
    }
    public Point_2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] getXY() {
        float[] arr = {x,y};
        return arr;
    }

    @Override
    public String toString() {
        return "Point_2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
