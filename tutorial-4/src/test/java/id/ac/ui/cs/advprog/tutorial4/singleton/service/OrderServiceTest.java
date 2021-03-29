package id.ac.ui.cs.advprog.tutorial4.singleton.service;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Soba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.LiyuanSoba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.MondoUdon;
import id.ac.ui.cs.advprog.tutorial4.factory.repository.MenuRepository;
import id.ac.ui.cs.advprog.tutorial4.factory.service.MenuService;
import id.ac.ui.cs.advprog.tutorial4.factory.service.MenuServiceImpl;
import id.ac.ui.cs.advprog.tutorial4.singleton.core.OrderDrink;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    public void testInit() {
        orderService = new OrderServiceImpl();
    }

    @Test
    public void testOrderADrinkMethod() {
        orderService.orderADrink("minuman");
        assertThat("minuman").isEqualTo(orderService.getDrink().getDrink());
    }

    @Test
    public void testGetDrinkMethod() {
        orderService.orderADrink("minuman");
        assertNotNull(orderService.getDrink());
    }

    @Test
    public void testOrderAFoodMethod() {
        orderService.orderAFood("makanan");
        assertThat("makanan").isEqualTo(orderService.getFood().getFood());
    }

    @Test
    public void testGetFoodMethod() {
        orderService.orderAFood("makanan");
        assertNotNull(orderService.getFood());
    }
}
