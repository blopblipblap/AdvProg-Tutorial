package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.IngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class Menu {
    String name;
    Noodle noodle;
    Meat meat;
    Topping topping;
    Flavor flavor;
    IngredientFactory ingredientFactory;

    //To Do : Complete Me
    //Silahkan tambahkan parameter jika dibutuhkan
    public Menu(String name, IngredientFactory ingredientFactory){
        this.name = name;
        this.ingredientFactory = ingredientFactory;
    }

    public String getName() {
        return name;
    }

    public Noodle getNoodle() {
        return noodle;
    }

    public Meat getMeat() {
        return meat;
    }

    public Topping getTopping() {
        return topping;
    }

    public Flavor getFlavor() {
        return flavor;
    }
}