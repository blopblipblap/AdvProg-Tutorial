package csui.advpro2021.tais.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.service.MataKuliahServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = MataKuliahController.class)
class MataKuliahControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MataKuliahServiceImpl mataKuliahService;

    private MataKuliah matkul;

    @BeforeEach
    public void setUp() {
        matkul = new MataKuliah("ADVPROG", "Advanced Programming", "Ilmu Komputer");
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    void testControllerGetListMataKuliah() throws Exception {
        Iterable<MataKuliah> listMataKuliah = Arrays.asList(matkul);
        when(mataKuliahService.getListMataKuliah()).thenReturn(listMataKuliah);

        mvc.perform(get("/mata-kuliah").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].kodeMatkul").value(matkul.getKodeMatkul()));
    }

    @Test
    void testControllerCreateMataKuliah() throws Exception {
        when(mataKuliahService.createMataKuliah(matkul)).thenReturn(matkul);

        mvc.perform(post("/mata-kuliah")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapToJson(matkul)))
                .andExpect(jsonPath("$.kodeMatkul").value(matkul.getKodeMatkul()));
    }

    @Test
    void testControllerGetMataKuliah() throws Exception {
        when(mataKuliahService.getMataKuliah(matkul.getKodeMatkul())).thenReturn(matkul);
        mvc.perform(get("/mata-kuliah/" + matkul.getKodeMatkul()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nama").value(matkul.getNama()));
    }

    @Test
    public void testControllerGetNonExistMataKuliah() throws Exception{
        mvc.perform(get("/mata-kuliah/BASDEAD").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testControllerUpdateMataKuliah() throws Exception {
        mataKuliahService.createMataKuliah(matkul);

        String namaMatkul = "ADV125YIHA";
        matkul.setNama(namaMatkul);

        when(mataKuliahService.updateMataKuliah(matkul.getKodeMatkul(), matkul)).thenReturn(matkul);

        mvc.perform(put("/mata-kuliah/" + matkul.getKodeMatkul()).contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(matkul)))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nama").value(namaMatkul));
    }

    @Test
    void testControllerDeleteMataKuliah() throws Exception {
        mataKuliahService.createMataKuliah(matkul);
        mvc.perform(delete("/mata-kuliah/" + matkul.getKodeMatkul()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}