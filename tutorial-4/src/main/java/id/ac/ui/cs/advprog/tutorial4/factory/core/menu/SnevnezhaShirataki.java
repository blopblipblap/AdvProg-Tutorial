package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.IngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.SnevnezhaShiratakiFactory;

public class SnevnezhaShirataki extends Menu {
    //Ingridients:
    //Noodle: Shirataki
    //Meat: Fish
    //Topping: Flower
    //Flavor: Umami
    public SnevnezhaShirataki(String name){
        super(name, new SnevnezhaShiratakiFactory());
        noodle = ingredientFactory.createNoodle();
        meat = ingredientFactory.createMeat();
        topping = ingredientFactory.createTopping();
        flavor = ingredientFactory.createFlavor();
    }
}