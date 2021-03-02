package id.ac.ui.cs.advprog.tutorial1.observer.controller;

import id.ac.ui.cs.advprog.tutorial1.observer.core.Guild;
import id.ac.ui.cs.advprog.tutorial1.observer.core.Quest;
import id.ac.ui.cs.advprog.tutorial1.observer.service.GuildServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ObserverController.class)
public class ObserverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Guild guild;

    @MockBean
    private GuildServiceImpl guildService;

    @Test
    public void whenCreateQuestURLIsAccessedItShouldContainCorrectQuestModel() throws Exception {
        mockMvc.perform(get("/create-quest"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("quest"))
            .andExpect(view().name("observer/questForm"));
    }

    @Test
    public void whenAddQuestURLIsAccessedItShouldCallGuildServiceAddQuest() throws Exception {
        Quest newQuest = new Quest();
        newQuest.setTitle("Dummy");
        newQuest.setType("R");

        mockMvc.perform(post("/add-quest")
            .flashAttr("quest", newQuest))
            .andExpect(handler().methodName("addQuest"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/adventurer-list"));
    }

    @Test
    public void whenAdventurerListURLIsAccessedItShouldContainAdventurersModel() throws Exception {
        mockMvc.perform(get("/adventurer-list"))
            .andExpect(status().isOk())
            .andExpect(view().name("observer/adventurerList"))
            .andExpect(model().attributeExists("adventurers"));
    }
}
