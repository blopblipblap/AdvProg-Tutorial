package csui.advpro2021.tais.controller;

import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.service.LogService;
import csui.advpro2021.tais.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping(produces = {"application/json"}, consumes = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity postLog(@RequestBody Log log) {
        return ResponseEntity.ok(logService.createLog(log));
    }

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Log>> getListLog() {
        return ResponseEntity.ok(logService.getListLog());
    }

    @GetMapping(path = "/{idLog}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getLog(@PathVariable(value = "idLog") Integer idLog) {
        Log log = logService.getLogByIdLog(idLog);
        if (log == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(log);
    }

    @PutMapping(path = "/{idLog}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateLog(@PathVariable(value = "idLog") Integer idLog, @RequestBody Log log) {
        return ResponseEntity.ok(logService.updateLog(idLog, log));
    }

    @DeleteMapping(path = "/{idLog}", produces = {"application/json"})
    public ResponseEntity deleteLog(@PathVariable(value = "idLog") Integer idLog) {
        logService.deleteLogByIdLog(idLog);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
