package csui.advpro2021.tais.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.Month;

public class LaporanPembayaran {
    @Id
    @Column(name = "Month")
    private Month month;

    @Column(name = "jamKerja")
    private Long jamKerja;

    @Column(name = "Pembayaran")
    private Long pembayaran;

    public LaporanPembayaran(Month month, Long jamKerja, Long pembayaran) {
        this.month = month;
        this.jamKerja = jamKerja;
        this.pembayaran = pembayaran;
    }
}
