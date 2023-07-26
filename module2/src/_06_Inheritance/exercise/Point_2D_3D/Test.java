package _06_Inheritance.exercise.Point_2D_3D;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // TEST POINT 2D
        Point_2D point2D = new Point_2D();
        System.out.println(point2D);
        point2D = new Point_2D(20,11);
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));
        System.out.printf("%n");
        // TEST POINT 3D
        Point_3D point3D = new Point_3D();
        System.out.println(point3D);
        point3D = new Point_3D(20, 11, 2000);
        System.out.println(point3D);
        System.out.println(Arrays.toString(point3D.getXYZ()));
    }
}
