package id.ac.ui.cs.advprog.tutorial4.singleton.core;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

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

    //Lazy instantiation
    public static OrderDrink getInstance() {
        if (orderDrink == null) {
            orderDrink = new OrderDrink();
        }
        return orderDrink;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return drink != null ? drink : "";
    }
}
