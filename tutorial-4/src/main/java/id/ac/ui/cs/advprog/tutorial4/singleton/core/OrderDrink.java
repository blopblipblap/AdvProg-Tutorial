package id.ac.ui.cs.advprog.tutorial4.singleton.core;

import java.lang.Thread;

public class OrderDrink {

    private String drink;

    private static OrderDrink orderDrink = null;

    private OrderDrink() {
        try{
            System.out.println("Creating.....");
            Thread.sleep(2000);
            System.out.println("Done.....");
        } catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    //Todo : Complete Me with lazy instantiation approach
    public static OrderDrink getInstance() {
        return null;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return drink;
    }
}
