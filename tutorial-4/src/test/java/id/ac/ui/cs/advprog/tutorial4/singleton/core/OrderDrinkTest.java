package id.ac.ui.cs.advprog.tutorial4.singleton.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDrinkTest {
    private Class<?> orderDrink;

    @BeforeEach
    public void setUp() throws Exception {
        orderDrink = Class.forName("id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink");
    }

    @Test
    public void testRamenIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(orderDrink.getModifiers()));
    }

    @Test
    public void testGetInstanceReturnsOneInstance() {
        OrderDrink drink = OrderDrink.getInstance();
        OrderDrink drink2 = OrderDrink.getInstance();

        assertEquals(drink, drink2);
    }

    @Test
    public void testGetDrinkAndSetDrink() {
        OrderDrink drink = OrderDrink.getInstance();

        drink.setDrink("minuman");
        assertEquals("minuman", drink.getDrink());

    }

    @Test
    public void testToString() {
        OrderDrink drink = OrderDrink.getInstance();
        String drinkName = drink.toString();
        assertEquals("", drinkName);

        drink.setDrink("minuman");
        assertEquals("minuman", drink.toString());

    }
}
