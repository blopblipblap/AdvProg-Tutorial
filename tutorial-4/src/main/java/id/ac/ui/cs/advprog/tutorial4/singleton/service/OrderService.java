package id.ac.ui.cs.advprog.tutorial4.singleton.service;

import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink;
import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderFood;
import org.springframework.stereotype.Service;

public interface OrderService {


    void orderADrink(String drink);
    OrderDrink getDrink();
    void orderAFood(String food);
    OrderFood getFood();
}
