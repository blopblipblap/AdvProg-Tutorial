package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.IngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.LiyuanSobaFactory;

public class LiyuanSoba extends Menu {

    public LiyuanSoba(String name) {
        super(name, new LiyuanSobaFactory());
        noodle = ingredientFactory.createNoodle();
        meat = ingredientFactory.createMeat();
        topping = ingredientFactory.createTopping();
        flavor = ingredientFactory.createFlavor();
    }
}