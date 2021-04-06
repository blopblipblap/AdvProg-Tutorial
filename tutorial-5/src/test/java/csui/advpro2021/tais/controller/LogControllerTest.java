package csui.advpro2021.tais.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.service.LogServiceImpl;
import csui.advpro2021.tais.service.MahasiswaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = LogController.class)
public class LogControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LogServiceImpl logService;

    private Log log;
    private Mahasiswa mahasiswa;
    private LaporanPembayaran laporanPembayaran;

    @BeforeEach
    public void setUp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = "2020-04-05 13:00:00";
        String str2 = "2020-04-05 15:00:00";
        log = new Log(1, LocalDateTime.parse(str, dtf), LocalDateTime.parse(str2, dtf), "rebahan");
        log.setIdLog(1);
        mahasiswa = new Mahasiswa("1906192052", "Maung Meong", "maung@cs.ui.ac.id", "4",
                "081317691718");
        laporanPembayaran = new LaporanPembayaran(Month.APRIL, 2L, 700L);
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //https://stackoverflow.com/questions/27952472/serialize-deserialize-java-8-java-time-with-jackson-json-mapper
        objectMapper.findAndRegisterModules();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void testControllerPostLog() throws Exception{

        when(logService.createLog(mahasiswa.getNpm(), log)).thenReturn(log);

        mvc.perform(post("/log/1906192052")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapToJson(log)))
                .andExpect(jsonPath("$.idLog").value(1));
    }

    @Test
    public void testControllerGetListLog() throws Exception{

        List<Log> listLog = Arrays.asList(log);
        when(logService.getListLog(mahasiswa.getNpm())).thenReturn(listLog);

        mvc.perform(get("/log/1906192052").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].idLog").value(1));
    }

    @Test
    public void testControllerGetLogByIdLog() throws Exception{

        when(logService.getLogByIdLog(mahasiswa.getNpm(), 1)).thenReturn(log);
        mvc.perform(get("/log/1906192052/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.deskripsi").value("rebahan"));
    }

    @Test
    public void testControllerGetNonExistLog() throws Exception{
        mvc.perform(get("/log/1906192052/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testControllerUpdateLog() throws Exception{

        logService.createLog(mahasiswa.getNpm(), log);

        //Update mahasiswa object nama
        log.setDeskripsi("lagi mengambiez");

        when(logService.updateLog(mahasiswa.getNpm(), 1, log)).thenReturn(log);

        mvc.perform(put("/log/1906192052/1").contentType(MediaType.APPLICATION_JSON)
                .content(mapToJson(log)))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.deskripsi").value("lagi mengambiez"));
    }

    @Test
    public void testControllerDeleteLog() throws Exception{
        logService.createLog(mahasiswa.getNpm(), log);
        mvc.perform(delete("/log/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testControllerGetLaporanPembayaran() throws Exception{
        Collection<LaporanPembayaran> collectionLaporan = Arrays.asList(laporanPembayaran);

        List<Log> listLog = Arrays.asList(log);
        when(logService.getLaporanPembayaran(mahasiswa.getNpm())).thenReturn(collectionLaporan);

        mvc.perform(get("/log/1906192052/laporan-pembayaran").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].jamKerja").value(2L));
    }
}
