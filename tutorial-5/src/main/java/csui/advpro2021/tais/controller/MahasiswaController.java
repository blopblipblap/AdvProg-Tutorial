package csui.advpro2021.tais.controller;

import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mahasiswa")
public class MahasiswaController {
    @Autowired
    private MahasiswaService mahasiswaService;

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity postMahasiswa(@RequestBody Mahasiswa mahasiswa) {
        return ResponseEntity.ok(mahasiswaService.createMahasiswa(mahasiswa));
    }

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<Mahasiswa>> getListMahasiswa() {
        return ResponseEntity.ok(mahasiswaService.getListMahasiswa());
    }

    @GetMapping(path = "/{npm}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getMahasiswa(@PathVariable(value = "npm") String npm) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswaByNPM(npm);
        if (mahasiswa == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(mahasiswa);
    }

    @PutMapping(path = "/{npm}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateMahasiswa(@PathVariable(value = "npm") String npm, @RequestBody Mahasiswa mahasiswa) {
        return ResponseEntity.ok(mahasiswaService.updateMahasiswa(npm, mahasiswa));
    }

    @DeleteMapping(path = "/{npm}", produces = {"application/json"})
    public ResponseEntity deleteMahasiswa(@PathVariable(value = "npm") String npm) {
        mahasiswaService.deleteMahasiswaByNPM(npm);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
