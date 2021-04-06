package csui.advpro2021.tais.controller;

import csui.advpro2021.tais.model.LaporanPembayaran;
import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.service.LogService;
import csui.advpro2021.tais.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping(path = "/{npm}", produces = {"application/json"}, consumes = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseEntity postLog(@PathVariable(value = "npm") String npm, @RequestBody Log log) {
        return ResponseEntity.ok(logService.createLog(npm, log));
    }

    @GetMapping(path = "/{npm}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<List<Log>> getListLog(@PathVariable(value = "npm") String npm) {
        return ResponseEntity.ok(logService.getListLog(npm));
    }

    @GetMapping(path = "/{npm}/{idLog}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getLog(@PathVariable(value = "npm") String npm, @PathVariable(value = "idLog") Integer idLog) {
        Log log = logService.getLogByIdLog(npm, idLog);
        if (log == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(log);
    }

    @PutMapping(path = "/{npm}/{idLog}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateLog(@PathVariable(value = "npm") String npm, @PathVariable(value = "idLog") Integer idLog, @RequestBody Log log) {
        return ResponseEntity.ok(logService.updateLog(npm, idLog, log));
    }

    @DeleteMapping(path = "/{idLog}", produces = {"application/json"})
    public ResponseEntity deleteLog(@PathVariable(value = "idLog") Integer idLog) {
        logService.deleteLogByIdLog(idLog);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{npm}/laporan-pembayaran", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Collection<LaporanPembayaran>> getLaporan(@PathVariable(value = "npm") String npm) {
        return ResponseEntity.ok(logService.getLaporanPembayaran(npm));
    }
}
