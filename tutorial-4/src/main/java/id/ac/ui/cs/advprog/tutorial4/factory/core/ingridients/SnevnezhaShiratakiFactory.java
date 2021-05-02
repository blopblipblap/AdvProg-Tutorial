package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Umami;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Fish;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Shirataki;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Flower;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class SnevnezhaShiratakiFactory implements IngredientFactory{
    //Ingridients:
    //Noodle: Shirataki
    //Meat: Fish
    //Topping: Flower
    //Flavor: Umami

    @Override
    public Flavor createFlavor() {
        return new Umami();
    }

    @Override
    public Meat createMeat() {
        return new Fish();
    }

    @Override
    public Noodle createNoodle() {
        return new Shirataki();
    }

    @Override
    public Topping createTopping() {
        return new Flower();
    }
}
