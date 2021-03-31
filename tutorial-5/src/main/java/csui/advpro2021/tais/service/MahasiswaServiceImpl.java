package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

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
        mahasiswaRepository.deleteById(npm);
    }
}
