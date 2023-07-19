package _05_accessModifier_staticMethod_staticProperty.practice.p2_static_property;

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car("Ferari","Red");
        System.out.println(Car.numOfCars);
        Car car2 = new Car("MEC", "black");
        System.out.println(Car.numOfCars);
    }
}
