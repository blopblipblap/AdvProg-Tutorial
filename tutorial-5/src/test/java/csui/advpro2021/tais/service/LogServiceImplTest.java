package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.repository.LogRepository;
import csui.advpro2021.tais.repository.MahasiswaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class LogServiceImplTest {
    @Mock
    private LogRepository logRepository;

    @Mock
    private MahasiswaRepository mahasiswaRepository;

    @InjectMocks
    private LogServiceImpl logService;

    @InjectMocks
    private MahasiswaServiceImpl mahasiswaService;

    private Log log;
    private Log extraLog;
    private Mahasiswa mahasiswa;
    private LaporanPembayaran laporanPembayaran;

    @BeforeEach
    public void setUp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str = "2020-04-05 13:00:00";
        String str2 = "2020-04-05 15:00:00";
        log = new Log();
        log.setIdLog(1);
        log.setStartLog(LocalDateTime.parse(str, dtf));
        log.setFinishLog(LocalDateTime.parse(str2, dtf));
        log.setDeskripsi("rebahan");

        extraLog = new Log();
        extraLog.setIdLog(2);
        extraLog.setStartLog(LocalDateTime.parse(str, dtf));
        extraLog.setFinishLog(LocalDateTime.parse(str2, dtf));
        extraLog.setDeskripsi("rebahan");

        mahasiswa = new Mahasiswa();
        mahasiswa.setNpm("1906192052");
        mahasiswa.setNama("Maung Meong");
        mahasiswa.setEmail("maung@cs.ui.ac.id");
        mahasiswa.setIpk("4");
        mahasiswa.setNoTelp("081317691718");

        laporanPembayaran = new LaporanPembayaran(Month.APRIL, 2L, 700L);
        laporanPembayaran.setMonth(Month.APRIL);
        laporanPembayaran.setJamKerja(2L);
        laporanPembayaran.setPembayaran(700L);
    }

    @Test
    public void testServiceCreateLog(){
        lenient().when(mahasiswaRepository.findByNpm("1906192052")).thenReturn(mahasiswa);

        lenient().when(logService.createLog(mahasiswa.getNpm(), log)).thenReturn(log);
    }

    @Test
    public void testServiceGetListLog(){
        List<Log> listLog = new ArrayList<>();
        for (Log log : logRepository.findAll()) {
            if (log.getAsdos().equals(mahasiswa)) {
                listLog.add(log);
            }
        }
        lenient().when(logService.getListLog("1906192052")).thenReturn(listLog);
        List<Log> listLogResult = logService.getListLog(mahasiswa.getNpm());
        Assertions.assertIterableEquals(listLog, listLogResult);
    }

    @Test
    public void testServiceGetListLogNoMahasiswa(){
        lenient().when(mahasiswaRepository.findByNpm(mahasiswa.getNpm())).thenReturn(mahasiswa);
        log.setAsdos(mahasiswa);
        List<Log> logs = new ArrayList<>();
        logs.add(log);
        lenient().when(logRepository.findAll()).thenReturn(logs);
        mahasiswa.setLog(logs);

        lenient().when(logService.getListLog("1906192052")).thenReturn(logs);
        List<Log> listLogResult = logService.getListLog(mahasiswa.getNpm());
        assertEquals(logs, listLogResult);
    }

    @Test
    public void testServiceGetLogByIdLog(){
        lenient().when(logService.getLogByIdLog("1906192052", 1)).thenReturn(log);
        Log resultLog = logService.getLogByIdLog(mahasiswa.getNpm(), log.getIdLog());
        assertEquals(log.getIdLog(), resultLog.getIdLog());
    }

    @Test
    public void testServiceDeleteLog(){
        logService.createLog("1906192052", log);
        logService.deleteLogByIdLog(1);
        lenient().when(logService.getLogByIdLog("1906192052",1)).thenReturn(null);
        assertEquals(null, logService.getLogByIdLog(mahasiswa.getNpm(), log.getIdLog()));
    }

    @Test
    public void testServiceUpdateLog(){
        logService.createLog("1906192052", log);
        String currentDeskripsi = log.getDeskripsi();
        //Change IPK from 4 to 3
        log.setDeskripsi("ngantuk bor");

        lenient().when(logService.updateLog("1906192052",1,log)).thenReturn(log);
        Log resultLog = logService.updateLog(mahasiswa.getNpm(), log.getIdLog(),log);

        assertNotEquals(resultLog.getDeskripsi(), currentDeskripsi);
        assertEquals(resultLog.getStartLog(), log.getStartLog());
    }

    //HELP NI LOM KELAR!!!!!!
    @Test
    public void testServiceGetLaporanPembayaranDifferentMonth(){
        lenient().when(mahasiswaRepository.findByNpm(mahasiswa.getNpm())).thenReturn(mahasiswa);
        log.setAsdos(mahasiswa);
        List<Log> logs = new ArrayList<>();
        logs.add(log);
        lenient().when(logRepository.findAll()).thenReturn(logs);
        mahasiswa.setLog(logs);

        Collection<LaporanPembayaran> laporan = logService.getLaporanPembayaran(mahasiswa.getNpm());
        assertEquals(1, laporan.size());
    }

    @Test
    public void testServiceGetLaporanPembayaranSameMonth(){
        lenient().when(mahasiswaRepository.findByNpm(mahasiswa.getNpm())).thenReturn(mahasiswa);
        log.setAsdos(mahasiswa);
        extraLog.setAsdos(mahasiswa);
        List<Log> logs = new ArrayList<>();
        logs.add(log);
        logs.add(extraLog);
        lenient().when(logRepository.findAll()).thenReturn(logs);
        mahasiswa.setLog(logs);

        Collection<LaporanPembayaran> laporan = logService.getLaporanPembayaran(mahasiswa.getNpm());
        assertEquals(1, laporan.size());
    }
}
