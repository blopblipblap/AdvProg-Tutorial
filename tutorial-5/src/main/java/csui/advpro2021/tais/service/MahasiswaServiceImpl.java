package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.repository.MahasiswaRepository;
import csui.advpro2021.tais.repository.MataKuliahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    @Autowired
    private MataKuliahRepository mataKuliahRepository;

    @Override
    public Mahasiswa createMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaRepository.save(mahasiswa);
        return mahasiswa;
    }

    @Override
    public Iterable<Mahasiswa> getListMahasiswa() {
        return mahasiswaRepository.findAll();
    }

    @Override
    public Mahasiswa getMahasiswaByNPM(String npm) {
        return mahasiswaRepository.findByNpm(npm);
    }

    @Override
    public Mahasiswa updateMahasiswa(String npm, Mahasiswa mahasiswa) {
        mahasiswa.setNpm(npm);
        mahasiswaRepository.save(mahasiswa);
        return mahasiswa;
    }

    @Override
    public void deleteMahasiswaByNPM(String npm) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        if (mahasiswa.getMataKuliah() == null) {
            mahasiswaRepository.deleteById(npm);
        }
    }

    @Override
    public Mahasiswa enrollMataKuliah(String npm, String kodeMatkul) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        MataKuliah mataKuliah = mataKuliahRepository.findByKodeMatkul(kodeMatkul);
        mahasiswa.setMataKuliah(mataKuliah);

        mahasiswa.setNpm(npm);
        mahasiswaRepository.save(mahasiswa);
        return mahasiswa;
    }
    @Override
    public Mahasiswa enrollAsdos(String npm, String kodeMatkul) {
        Mahasiswa mahasiswa = mahasiswaRepository.findByNpm(npm);
        MataKuliah mataKuliah = mataKuliahRepository.findByKodeMatkul(kodeMatkul);
        mahasiswa.setMatkulAsdosan(mataKuliah);
        List<Mahasiswa> asdos = mataKuliah.getAsdos();
        asdos.add(mahasiswa);

        mahasiswa.setNpm(npm);
        mahasiswaRepository.save(mahasiswa);
        return mahasiswa;
    }
}
