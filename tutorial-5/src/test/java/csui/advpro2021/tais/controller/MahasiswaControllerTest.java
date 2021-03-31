package csui.advpro2021.tais.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.service.MahasiswaServiceImpl;
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


@WebMvcTest(controllers = MahasiswaController.class)
public class MahasiswaControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MahasiswaServiceImpl mahasiswaService;

    private Mahasiswa mahasiswa;

    @BeforeEach
    public void setUp(){
        mahasiswa = new Mahasiswa("1906192052", "Maung Meong", "maung@cs.ui.ac.id", "4",
                "081317691718");
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void testControllerPostMahasiswa() throws Exception{

        when(mahasiswaService.createMahasiswa(mahasiswa)).thenReturn(mahasiswa);

        mvc.perform(post("/mahasiswa")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(mahasiswa)))
                .andExpect(jsonPath("$.npm").value("1906192052"));
    }

    @Test
    public void testControllerGetListMahasiswa() throws Exception{

        Iterable<Mahasiswa> listMahasiswa = Arrays.asList(mahasiswa);
        when(mahasiswaService.getListMahasiswa()).thenReturn(listMahasiswa);

        mvc.perform(get("/mahasiswa").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].npm").value("1906192052"));
    }

    @Test
    public void testControllerGetMahasiswaByNpm() throws Exception{

        when(mahasiswaService.getMahasiswaByNPM("1906192052")).thenReturn(mahasiswa);
        mvc.perform(get("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nama").value("Maung Meong"));
    }

    @Test
    public void testControllerGetNonExistMahasiswa() throws Exception{
        mvc.perform(get("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testControllerUpdateMahasiswa() throws Exception{

        mahasiswaService.createMahasiswa(mahasiswa);

        //Update mahasiswa object nama
        mahasiswa.setNama("Quanta Quantul");

        when(mahasiswaService.updateMahasiswa(mahasiswa.getNpm(), mahasiswa)).thenReturn(mahasiswa);

        mvc.perform(put("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(mahasiswa)))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nama").value("Quanta Quantul"));
    }

    @Test
    public void testControllerDeleteMahasiswa() throws Exception{
        mahasiswaService.createMahasiswa(mahasiswa);
        mvc.perform(delete("/mahasiswa/1906192052").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }



}
