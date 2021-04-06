package csui.advpro2021.tais.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

@Entity
@Table(name = "log")
@Data
@NoArgsConstructor
@SequenceGenerator(name="seq", initialValue = 1)
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "idLog", updatable = false, nullable = false)
    private Integer idLog;

    @Column(name = "startLog")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startLog;

    @Column(name = "endLog")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finishLog;

    @Column(name = "deskripsi")
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "asdos", referencedColumnName = "npm")
    @JsonIgnore private Mahasiswa asdos;

    public Log(Integer idLog, LocalDateTime startLog, LocalDateTime finishLog, String deskripsi) {
        this.idLog = idLog;
        this.startLog = startLog;
        this.finishLog = finishLog;
        this.deskripsi = deskripsi;
    }
}
