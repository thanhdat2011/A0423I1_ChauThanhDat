package _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Animal;

import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Abstract_Interface.Animal;
import _07_Abstract_Interface.Practice.Animal_class_Edible_interface.Abstract_Interface.IEdible;

public class Chicken extends Animal implements IEdible {
    @Override
    public String makeSound() {
        return "Chicken : oc oc oc oc";
    }

    @Override
    public String howToEat() {
        return "cooking";
    }
}
