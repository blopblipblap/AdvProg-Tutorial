package id.ac.ui.cs.advprog.tutorial4.singleton.service;

import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink;
import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderFood;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDrink orderDrink;

    public void orderADrink(String drink) {
        if (orderDrink == null) {
            orderDrink = OrderDrink.getInstance();
        }
        orderDrink.setDrink(drink);
    }

    public OrderDrink getDrink() {
        if (orderDrink == null) {
            orderDrink = OrderDrink.getInstance();
        }
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
