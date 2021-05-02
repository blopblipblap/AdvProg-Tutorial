package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.IngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.SnevnezhaShiratakiFactory;

public class SnevnezhaShirataki extends Menu {

    public SnevnezhaShirataki(String name){
        super(name, new SnevnezhaShiratakiFactory());
        noodle = ingredientFactory.createNoodle();
        meat = ingredientFactory.createMeat();
        topping = ingredientFactory.createTopping();
        flavor = ingredientFactory.createFlavor();
    }
}