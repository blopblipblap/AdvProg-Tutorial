package id.ac.ui.cs.advprog.tutorial2.command.controller;

import id.ac.ui.cs.advprog.tutorial2.command.service.SealServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = SealController.class)
public class SealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SealServiceImpl sealService;

    @Test
    public void whenSealHomeURLIsAccessedItShouldContainCorrectQuestModel() throws Exception {
        mockMvc.perform(get("/seal"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("spells"))
                .andExpect(model().attributeExists("familiars"))
                .andExpect(model().attributeExists("spirits"))
                .andExpect(view().name("command/sealHome"));
    }

    @Test
    public void whenCastSpellURLIsAccessedItShouldCallSealServiceCastSpell() throws Exception {
        String spellName = "iceberg";

        mockMvc.perform(post("/cast")
                .param("spellName", spellName))
                .andExpect(handler().methodName("castSpell"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/seal"));
    }

    @Test
    public void whenUndoSpellURLIsAccessedItShouldCallSealServiceUndoSpell() throws Exception {
        mockMvc.perform(get("/undo"))
                .andExpect(handler().methodName("undoSpell"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/seal"));
    }
}

