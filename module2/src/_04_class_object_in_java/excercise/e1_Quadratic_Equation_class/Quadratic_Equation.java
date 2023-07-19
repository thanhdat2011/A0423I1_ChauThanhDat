package _04_class_object_in_java.excercise.e1_Quadratic_Equation_class;

public class Quadratic_Equation {
    private double a,b,c;
    Quadratic_Equation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    Quadratic_Equation() {

    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    double getDiscriminant() {
        return Math.pow(b, 2) - 4* a* c;
    }
    double getRoot1(){
        if (getDiscriminant() >= 0) {
            return (-b + Math.pow(getDiscriminant(), 0.5)) / (2 * a);
        } else return 0;
    }
    double getRoot2(){
        if (getDiscriminant() >= 0) {
            return (-b - Math.pow(getDiscriminant(), 0.5)) / (2 * a);
        } else return 0;
    }

}
