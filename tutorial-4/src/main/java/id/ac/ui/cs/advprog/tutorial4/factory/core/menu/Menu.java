package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.IngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;

public class Menu {
    protected String name;
    protected Noodle noodle;
    protected Meat meat;
    protected Topping topping;
    protected Flavor flavor;
    protected IngredientFactory ingredientFactory;

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