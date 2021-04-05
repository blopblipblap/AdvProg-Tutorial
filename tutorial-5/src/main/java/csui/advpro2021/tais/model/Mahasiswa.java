package csui.advpro2021.tais.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mahasiswa")
@Data
@NoArgsConstructor
public class Mahasiswa {

    @Id
    @Column(name = "npm", updatable = false, nullable = false)
    private String npm;

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "ipk")
    private String ipk;

    @Column(name = "no_telp")
    private String noTelp;

    @ManyToOne
    @JoinColumn(name = "daftar_matkul", referencedColumnName = "kode_matkul")
    private MataKuliah mataKuliah;

    @ManyToOne
    @JoinColumn(name = "asdos_matkul", referencedColumnName = "kode_matkul")
    private MataKuliah matkulAsdosan;


    public Mahasiswa(String npm, String nama, String email, String ipk, String noTelp) {
        this.npm = npm;
        this.nama = nama;
        this.email = email;
        this.ipk = ipk;
        this.noTelp = noTelp;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }
}
