package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Log;

public interface LogService {
    Log createLog(Log log);

    Iterable<Log> getListLog();

    Log getLogByIdLog(Integer idLog);

    Log updateLog(Integer idLog, Log log);

    void deleteLogByIdLog(Integer idLog);
}
