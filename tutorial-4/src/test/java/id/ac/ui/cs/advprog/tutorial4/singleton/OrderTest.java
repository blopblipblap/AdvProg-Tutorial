package id.ac.ui.cs.advprog.tutorial4.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;


import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink;
import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderFood;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {

    private Class<?> orderDrinkClass;
    private OrderDrink orderDrink;

    private Class<?> orderFoodClass;
    private OrderFood orderFood;

    @BeforeEach
    public void setUp() throws Exception {
        orderDrinkClass = Class.forName(OrderDrink.class.getName());
        orderDrink = OrderDrink.getInstance();

        orderFoodClass = Class.forName(OrderFood.class.getName());
        orderFood = OrderFood.getInstance();
    }

    @Test
    public void testNoPublicConstructors() {
        List<Constructor> constructors = Arrays.asList(orderDrinkClass.getDeclaredConstructors());

        boolean check = constructors.stream()
                .anyMatch(c -> !Modifier.isPrivate(c.getModifiers()));

        assertEquals(false, check);
    }

    @Test
    public void testNoPublicConstructors2() {
        List<Constructor> constructors = Arrays.asList(orderFoodClass.getDeclaredConstructors());

        boolean check = constructors.stream()
                .anyMatch(c -> !Modifier.isPrivate(c.getModifiers()));

        assertEquals(false, check);
    }


    @Test
    public void testGetInstanceShouldReturnSingletonInstance() {
        OrderDrink orderDrink = OrderDrink.getInstance();

        assertNotNull(orderDrink);
    }

    @Test
    public void testGetInstanceShouldReturnSingletonInstance2() {
        OrderFood orderFood = OrderFood.getInstance();

        assertNotNull(orderFood);
    }

    @Test
    public void testOrderDrink(){
        orderDrink.setDrink("Bir Bintang");
        assertEquals("Bir Bintang", orderDrink.getDrink());
    }

    @Test
    public void testOrderFood(){
        orderFood.setFood("Tonkotsu Ramen");
        assertEquals("Tonkotsu Ramen", orderFood.getFood());
    }

    @Test
    public void testOrderDrinkExist(){
        assertNotNull(orderDrink.toString());
    }

    @Test
    public void testOrderFoodExist(){
        assertNotNull(orderFood.toString());
    }

}
