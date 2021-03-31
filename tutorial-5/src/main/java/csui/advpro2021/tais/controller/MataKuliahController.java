package csui.advpro2021.tais.controller;

import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mata-kuliah")
public class MataKuliahController {
    @Autowired
    private MataKuliahService mataKuliahService;

    @GetMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Iterable<MataKuliah>> getListMataKuliah() {
        return ResponseEntity.ok(mataKuliahService.getListMataKuliah());
    }

    @PostMapping(produces = {"application/json"})
    @ResponseBody
    public ResponseEntity createMataKuliah(@RequestBody MataKuliah mataKuliah) {
        return ResponseEntity.ok(mataKuliahService.createMataKuliah(mataKuliah));
    }

    @GetMapping(path = "/{kodeMatkul}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity getMataKuliah(@PathVariable(value = "kodeMatkul") String kodeMatkul) {
        MataKuliah matkul = mataKuliahService.getMataKuliah(kodeMatkul);
        if (matkul == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(matkul);
    }

    @PutMapping(path = "/{kodeMatkul}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity updateMataKuliah(@PathVariable(value = "kodeMatkul") String kodeMatkul, @RequestBody MataKuliah mataKuliah) {
        return ResponseEntity.ok(mataKuliahService.updateMataKuliah(kodeMatkul, mataKuliah));
    }

    @DeleteMapping(path = "/{kodeMatkul}", produces = {"application/json"})
    public ResponseEntity deleteMataKuliah(@PathVariable(value = "kodeMatkul") String kodeMatkul) {
        mataKuliahService.deleteMataKuliah(kodeMatkul);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
