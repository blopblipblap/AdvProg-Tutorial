package id.ac.ui.cs.advprog.tutorial4.singleton.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderFoodTest {
    private Class<?> orderFood;

    @BeforeEach
    public void setUp() throws Exception {
        orderFood = Class.forName("id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderFood");
    }

    @Test
    public void testRamenIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(orderFood.getModifiers()));
    }

    @Test
    public void testGetInstanceReturnsOneInstance() {
        OrderFood food = OrderFood.getInstance();
        OrderFood food2 = OrderFood.getInstance();

        assertEquals(food, food2);
    }

    @Test
    public void testGetFoodAndSetFood() {
        OrderFood food = OrderFood.getInstance();

        food.setFood("makanan");
        assertEquals("makanan", food.getFood());

    }

    @Test
    public void testToString() {
        OrderFood food = OrderFood.getInstance();
        String foodName = food.toString();
        assertEquals("", foodName);

        food.setFood("makanan");
        assertEquals("makanan", food.toString());

    }
}
