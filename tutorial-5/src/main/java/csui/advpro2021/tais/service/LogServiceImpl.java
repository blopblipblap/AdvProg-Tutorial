package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    LogRepository logRepository;

    @Override
    public Log createLog(Log log) {
        logRepository.save(log);
        return log;
    }

    @Override
    public Iterable<Log> getListLog() {
        return logRepository.findAll();
    }

    @Override
    public Log getLogByIdLog(Integer idLog) {
        return logRepository.findByIdLog(idLog);
    }

    @Override
    public Log updateLog(Integer idLog, Log log) {
        log.setIdLog(idLog);
        logRepository.save(log);
        return log;
    }

    @Override
    public void deleteLogByIdLog(Integer idLog) {
        logRepository.deleteById(idLog);
    }
}
