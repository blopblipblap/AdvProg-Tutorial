package id.ac.ui.cs.advprog.tutorial4.singleton.core;

import java.lang.Thread;

public class OrderFood {

    private String food;

    private static OrderFood orderFood = new OrderFood();

    private OrderFood() {
        try{
            System.out.println("Creating.....");
            Thread.sleep(2000);
            System.out.println("Done....");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    //Todo : Complete Me with eager instantiation approach
    public static OrderFood getInstance() {
        return orderFood;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return food != null ? food : "";
    }
}
