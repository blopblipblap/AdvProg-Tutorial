package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Mahasiswa;

public interface MahasiswaService {
    Mahasiswa createMahasiswa(Mahasiswa mahasiswa);

    Iterable<Mahasiswa> getListMahasiswa();

    Mahasiswa getMahasiswaByNPM(String npm);

    Mahasiswa updateMahasiswa(String npm, Mahasiswa mahasiswa);

    void deleteMahasiswaByNPM(String npm);
}
