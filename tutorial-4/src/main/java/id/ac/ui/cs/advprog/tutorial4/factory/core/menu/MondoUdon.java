package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.IngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.MondoUdonFactory;

public class MondoUdon extends Menu {
    //Ingridients:
    //Noodle: Udon
    //Meat: Chicken
    //Topping: Cheese
    //Flavor: Salty
    public MondoUdon(String name){
        super(name, new MondoUdonFactory());
        noodle = ingredientFactory.createNoodle();
        meat = ingredientFactory.createMeat();
        topping = ingredientFactory.createTopping();
        flavor = ingredientFactory.createFlavor();
    }
}