package _07_Abstract_Interface.Practice.Animal_class_Edible_interface;

import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Abstract_Interface.Animal;
import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Abstract_Interface.Fruit;
import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Abstract_Interface.IEdible;
import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Animal.Chicken;
import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Animal.Tiger;
import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Fruit.Apple;
import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Fruit.Orange;

public class Test {
    public static void main(String[] args) {
        // Test animal
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                IEdible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
        System.out.println("\n-------------");
        // Test Fruit
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }


}
