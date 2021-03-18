package id.ac.ui.cs.advprog.tutorial3.adapter.controller;

import id.ac.ui.cs.advprog.tutorial3.adapter.service.WeaponServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AdapterController.class)
public class AdapterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeaponServiceImpl weaponService;

    @Test
    public void whenBattleHomeURLIsAccessedItShouldContainWeaponChoiceAndBattleLog() throws Exception {
        mockMvc.perform(get("/battle"))
                .andExpect(status().isOk())
                .andExpect(handler().methodName("battleHome"))
                .andExpect(model().attributeExists("weapons"))
                .andExpect(model().attributeExists("logs"))
                .andExpect(view().name("adapter/home"));
        verify(weaponService, times(1)).findAll();
        verify(weaponService, times(1)).getAllLogs();
    }

    @Test
    public void whenAttackURLIsAccessedItShouldCallAttackWithWeapon() throws Exception {
        mockMvc.perform(post("/battle/attack")
                .param("weaponName", "Ionic Bow")
                .param("attackType", "1"))
                .andExpect(handler().methodName("attackWithWeapon"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/battle"));
        verify(weaponService, times(1)).attackWithWeapon("Ionic Bow", 1);
    }
}
