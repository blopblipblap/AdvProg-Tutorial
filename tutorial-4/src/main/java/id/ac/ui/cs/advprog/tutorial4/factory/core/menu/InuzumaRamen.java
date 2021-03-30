package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.IngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.InuzumaRamenFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class InuzumaRamen extends Menu {

    public InuzumaRamen(String name){
        super(name, new InuzumaRamenFactory());
        noodle = ingredientFactory.createNoodle();
        meat = ingredientFactory.createMeat();
        topping = ingredientFactory.createTopping();
        flavor = ingredientFactory.createFlavor();
    }
}