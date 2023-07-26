package _06_Inheritance.exercise.Point_2D_3D;

public class Point_3D extends Point_2D {
    private float z;

    public Point_3D() {
        z = 0.0f;
    }
    public Point_3D(float x, float y, float z) {
        super(x,y);
        this.z = z;
    }
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z) {
        super.setXY(x,y);
        this.z = z;
    }
    public float[] getXYZ() {
        float[] arr = {getX(), getY(), z};
        return arr;
    }

    @Override
    public String toString() {
        return "Point_3D{" +
                "x = " + getX() +
                ", y = " + getY() +
                ", z = " + z +
                '}';
    }
}
