package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;

import java.util.*;

public interface LogService {
    Log createLog(String npm, Log log);

    List<Log> getListLog(String npm);

    Log getLogByIdLog(String npm, Integer idLog);

    Log updateLog(String npm, Integer idLog, Log log);

    void deleteLogByIdLog(Integer idLog);

    Collection<LaporanPembayaran> getLaporanPembayaran(String npm);
}
