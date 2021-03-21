package id.ac.ui.cs.advprog.tutorial2.template.controller;

import id.ac.ui.cs.advprog.tutorial2.template.service.QuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = QuestController.class)
public class QuestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestService questService;

    @Test
    public void whenQuestHomeURLIsAccessedItShouldContainCorrectQuestModel() throws Exception {
        mockMvc.perform(get("/attack"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("Saber"))
                .andExpect(model().attributeExists("Archer"))
                .andExpect(model().attributeExists("Lancer"))
                .andExpect(view().name("template/quest"));
    }
}