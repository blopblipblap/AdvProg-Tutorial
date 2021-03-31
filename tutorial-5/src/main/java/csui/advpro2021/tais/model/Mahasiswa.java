package csui.advpro2021.tais.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public Mahasiswa(String npm, String nama, String email, String ipk, String noTelp) {
        this.npm = npm;
        this.nama = nama;
        this.email = email;
        this.ipk = ipk;
        this.noTelp = noTelp;
    }
}
