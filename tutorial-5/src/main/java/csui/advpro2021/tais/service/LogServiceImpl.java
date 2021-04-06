package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.repository.LogRepository;
import csui.advpro2021.tais.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    LogRepository logRepository;
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Override
    public Log createLog(String npm, Log log) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        log.setAsdos(mahasiswa);
        logRepository.save(log);
        return log;
    }

    @Override
    public List<Log> getListLog(String npm) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        List<Log> logs = new ArrayList<>();
        for (Log log : logRepository.findAll()) {
            if (log.getAsdos().equals(mahasiswa)) {
                logs.add(log);
            }
        }
        return logs;
    }

    @Override
    public Log getLogByIdLog(String npm, Integer idLog) {
        return logRepository.findByIdLog(idLog);
    }

    @Override
    public Log updateLog(String npm, Integer idLog, Log log) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        log.setAsdos(mahasiswa);
        log.setIdLog(idLog);
        logRepository.save(log);
        return log;
    }

    @Override
    public void deleteLogByIdLog(Integer idLog) {
        logRepository.deleteById(idLog);
    }

    @Override
    public Collection<LaporanPembayaran> getLaporanPembayaran(String npm) {
        Map<Integer, LaporanPembayaran> mapLaporan = new HashMap<>();
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        for (Log log : logRepository.findAll()) {
            if (log.getAsdos().equals(mahasiswa)) {
                LocalDateTime startLog = log.getStartLog();
                LocalDateTime finishLog = log.getFinishLog();
                Duration durasi = Duration.between(startLog,finishLog);

                Long jamKerja = durasi.toHours();
                Long pembayaran = 350*jamKerja;
                Integer month = startLog.getMonth().getValue();
                if (mapLaporan.containsKey(month)) {
                    LaporanPembayaran laporan = mapLaporan.get(month);
                    laporan.setPembayaran(pembayaran + laporan.getPembayaran());
                    laporan.setMonth(startLog.getMonth());
                    laporan.setJamKerja(jamKerja + laporan.getJamKerja());
                } else {
                    LaporanPembayaran laporan = new LaporanPembayaran(startLog.getMonth(), jamKerja, pembayaran);
                    mapLaporan.put(month, laporan);
                }
            }
        }
        return mapLaporan.values();
    }
}
