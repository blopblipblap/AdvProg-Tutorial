package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public interface IngredientFactory {
    // Menyediakan method create<Ingredient>
    public Flavor createFlavor();
    public Meat createMeat();
    public Noodle createNoodle();
    public Topping createTopping();
}
