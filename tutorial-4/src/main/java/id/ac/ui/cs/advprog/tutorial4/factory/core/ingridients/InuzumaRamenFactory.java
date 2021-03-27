package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class InuzumaRamenFactory implements IngredientFactory{

    @Override
    public Flavor createFlavor() {
        return new Spicy();
    }

    @Override
    public Meat createMeat() {
        return new Pork();
    }

    @Override
    public Noodle createNoodle() {
        return new Ramen();
    }

    @Override
    public Topping createTopping() {
        return new BoiledEgg();
    }
}
