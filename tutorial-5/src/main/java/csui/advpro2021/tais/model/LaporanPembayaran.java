package csui.advpro2021.tais.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;

public class LaporanPembayaran {

    private Month month;
    private Long jamKerja;
    private Long pembayaran;

    public LaporanPembayaran(Month month, Long jamKerja, Long pembayaran) {
        this.month = month;
        this.jamKerja = jamKerja;
        this.pembayaran = pembayaran;
    }

    public Long getJamKerja() {
        return jamKerja;
    }

    public Long getPembayaran() {
        return pembayaran;
    }

    public Month getMonth() {
        return month;
    }

    public void setJamKerja(Long jamKerja) {
        this.jamKerja = jamKerja;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setPembayaran(Long pembayaran) {
        this.pembayaran = pembayaran;
    }
}
