package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.MataKuliah;

public interface MataKuliahService {
    Iterable<MataKuliah> getListMataKuliah();

    MataKuliah createMataKuliah(MataKuliah mataKuliah);

    MataKuliah getMataKuliah(String kodeMatkul);

    MataKuliah updateMataKuliah(String kodeMatkul, MataKuliah mataKuliah);

    void deleteMataKuliah(String kodeMatkul);
}
