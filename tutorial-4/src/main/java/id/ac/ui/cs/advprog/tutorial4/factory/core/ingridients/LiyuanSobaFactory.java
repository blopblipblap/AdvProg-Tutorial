package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Sweet;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Beef;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Soba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Mushroom;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class LiyuanSobaFactory implements IngredientFactory{
    //Ingridients:
    //Noodle: Soba
    //Meat: Beef
    //Topping: Mushroom
    //Flavor: Sweet

    @Override
    public Flavor createFlavor() {
        return new Sweet();
    }

    @Override
    public Meat createMeat() {
        return new Beef();
    }

    @Override
    public Noodle createNoodle() {
        return new Soba();
    }

    @Override
    public Topping createTopping() {
        return new Mushroom();
    }
}
