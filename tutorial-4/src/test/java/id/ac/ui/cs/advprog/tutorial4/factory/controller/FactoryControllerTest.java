package id.ac.ui.cs.advprog.tutorial4.factory.controller;

import id.ac.ui.cs.advprog.tutorial4.factory.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = FactoryController.class)
public class FactoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenuService menuService;

    @Test
    public void whenCreateMenuUrlShouldCallMenuService() throws Exception{
        mockMvc.perform(get("/menus"))
            .andExpect(status().isOk())
            .andExpect(handler().methodName("getmenus"))
            .andExpect(model().attributeExists("RestaurantMenu"))
            .andExpect(view().name("factory/menus"));
        verify(menuService, times(1)).getMenus();
    }

    @Test
    public void whenNewMenuShouldCallNewMenu() throws Exception {
        mockMvc.perform(post("/newMenu")
        .param("name", "udon")
        .param("type", "MondoUdon"))
            .andExpect(handler().methodName("createMenu"));

        verify(menuService, times(1)).createMenu("udon", "MondoUdon");
    }
}
