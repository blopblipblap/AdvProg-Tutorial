package csui.advpro2021.tais.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startLog;

    @Column(name = "endLog")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date finishLog;

    @Column(name = "deskripsi")
    private String deskripsi;

    public Log(Integer idLog, Date startLog, Date finishLog, String deskripsi) {
        this.idLog = idLog;
        this.startLog = startLog;
        this.finishLog = finishLog;
        this.deskripsi = deskripsi;
    }
}
