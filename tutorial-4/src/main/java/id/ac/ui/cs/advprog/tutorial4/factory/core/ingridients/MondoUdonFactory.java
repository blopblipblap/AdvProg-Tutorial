package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Salty;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Chicken;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Udon;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Cheese;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class MondoUdonFactory implements IngredientFactory{
    @Override
    public Flavor createFlavor() {
        return new Salty();
    }

    @Override
    public Meat createMeat() {
        return new Chicken();
    }

    @Override
    public Noodle createNoodle() {
        return new Udon();
    }

    @Override
    public Topping createTopping() {
        return new Cheese();
    }
}
