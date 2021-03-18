package id.ac.ui.cs.advprog.tutorial3.facade.controller;

import id.ac.ui.cs.advprog.tutorial3.facade.service.FacadeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@WebMvcTest(controllers = FacadeController.class)
public class FacadeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacadeServiceImpl facadeService;

    @Test
    public void whenRunicArtsURLIsAccessedItShouldReturnHomepage() throws Exception {
        mockMvc.perform(get("/runicArts/"))
                .andExpect(status().isOk())
                .andExpect(handler().methodName("home"))
                .andExpect(view().name("facade/translateForm"));
    }

    @Test
    public void whenTranslateFormURLIsAccessedItShouldSetRequestToService() throws Exception {
        mockMvc.perform(post("/runicArts/processTranslate")
                .param("text", "Safira and I went to a blacksmith to forge our sword")
                .param("type", "encode"))
                .andExpect(handler().methodName("translateForm"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/runicArts/translate"));

        verify(facadeService, times(1)).setRequestType(any(String.class));
        verify(facadeService, times(1)).setRequestValue(any(String.class));
    }

    @Test
    public void whenTranslateURLIsAccessedItShouldReturnTranslationValue() throws Exception {
        when(facadeService.getRequestValue())
                .thenReturn("Safira and I went to a blacksmith to forge our sword");
        when(facadeService.isRequestEncode()).thenReturn(true);
        when(facadeService.encode(any(String.class))).thenReturn("Dummy result");
        mockMvc.perform(get("/runicArts/translate"))
                .andExpect(status().isOk())
                .andExpect(handler().methodName("processText"))
                .andExpect(model().attributeExists("inputType"))
                .andExpect(model().attributeExists("input"))
                .andExpect(model().attributeExists("result"))
                .andExpect(view().name("facade/result"));

        verify(facadeService, times(1)).isRequestEncode();
        verify(facadeService, times(1)).getRequestValue();
        verify(facadeService, times(1)).encode(any(String.class));

        when(facadeService.isRequestEncode()).thenReturn(false);
        when(facadeService.decode(any(String.class))).thenReturn("Dummy result");
        mockMvc.perform(get("/runicArts/translate"))
                .andExpect(status().isOk())
                .andExpect(handler().methodName("processText"))
                .andExpect(model().attributeExists("inputType"))
                .andExpect(model().attributeExists("input"))
                .andExpect(model().attributeExists("result"))
                .andExpect(view().name("facade/result"));
        verify(facadeService, times(1)).decode(any(String.class));
    }
}

