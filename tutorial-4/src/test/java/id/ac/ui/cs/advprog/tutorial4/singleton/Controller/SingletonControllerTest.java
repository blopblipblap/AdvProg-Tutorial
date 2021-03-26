package id.ac.ui.cs.advprog.tutorial4.singleton.Controller;

import id.ac.ui.cs.advprog.tutorial4.singleton.controller.SingletonController;
import id.ac.ui.cs.advprog.tutorial4.singleton.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = SingletonController.class)
public class SingletonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void whenWanPlusHomeCalledShouldBeCorrect() throws Exception {
        mockMvc.perform(get("/singleton/"))
            .andExpect(status().isOk())
            .andExpect(handler().methodName("wanPlusRestaurantHome"))
            .andExpect(model().attributeExists("orderDrink"))
            .andExpect(view().name("orderFood"));
        verify(orderService, times(1)).getDrink();
        verify(orderService, times(1)).getFood();
    }

    @Test
    public void whenOrderFoodIsMadeShouldCallOrderFood() throws Exception {
        mockMvc.perform(post("/singleton/order-a-food")
        .param("food", "sticky honey roast"))
        .andExpect(handler().methodName("orderAFood"));

        verify(orderService, times(1)).orderAFood("sticky honey roast");
    }

    @Test
    public void whenOrderDrinkIsMadeShouldCallOrderFood() throws Exception {
        mockMvc.perform(post("/singleton/order-a-drink")
            .param("drink", "dandelion wine"))
            .andExpect(handler().methodName("orderADrink"));

        verify(orderService, times(1)).orderADrink("dandelion wine");
    }

}
