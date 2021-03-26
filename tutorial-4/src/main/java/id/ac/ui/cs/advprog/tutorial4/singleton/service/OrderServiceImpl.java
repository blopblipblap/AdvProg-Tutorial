package id.ac.ui.cs.advprog.tutorial4.singleton.service;

import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink;
import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderFood;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDrink orderDrink = OrderDrink.getInstance();

    public void orderADrink(String drink) {
        orderDrink.setDrink(drink);
    }

    public OrderDrink getDrink() {
        return orderDrink;
    }

    private OrderFood orderFood = OrderFood.getInstance();

    public void orderAFood(String food) {
        orderFood.setFood(food);
    }

    public OrderFood getFood() {
        return orderFood;
    }
}
