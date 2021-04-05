package csui.advpro2021.tais.controller;

import csui.advpro2021.tais.model.Log;
import csui.advpro2021.tais.model.Mahasiswa;
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
}
