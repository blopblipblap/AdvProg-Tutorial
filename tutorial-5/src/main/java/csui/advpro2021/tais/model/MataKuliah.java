package csui.advpro2021.tais.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mata_kuliah")
@Data
@NoArgsConstructor
public class MataKuliah {
    @Id
    @Column(name = "kode_matkul", updatable = false)
    private String kodeMatkul;

    @Column(name = "nama_matkul")
    private String nama;

    @Column(name = "prodi")
    private String prodi;

    public MataKuliah(String kodeMatkul, String nama, String prodi) {
        this.kodeMatkul = kodeMatkul;
        this.nama = nama;
        this.prodi = prodi;
    }
}
