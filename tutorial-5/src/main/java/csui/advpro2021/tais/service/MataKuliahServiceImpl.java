package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.repository.MataKuliahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MataKuliahServiceImpl implements MataKuliahService {
    @Autowired
    private MataKuliahRepository mataKuliahRepository;

    @Override
    public Iterable<MataKuliah> getListMataKuliah() {
        return mataKuliahRepository.findAll();
    }

    @Override
    public MataKuliah getMataKuliah(String kodeMatkul) {
        return mataKuliahRepository.findByKodeMatkul(kodeMatkul);
    }

    @Override
    public MataKuliah createMataKuliah(MataKuliah mataKuliah) {
        mataKuliahRepository.save(mataKuliah);
        return mataKuliah;
    }

    @Override
    public MataKuliah updateMataKuliah(String kodeMatkul, MataKuliah mataKuliah) {
        mataKuliah.setKodeMatkul(kodeMatkul);
        mataKuliahRepository.save(mataKuliah);
        return mataKuliah;
    }

    @Override
    public void deleteMataKuliah(String kodeMatkul) {
        MataKuliah matkul = this.getMataKuliah(kodeMatkul);
        if (matkul.getAsdos() == null) {
            mataKuliahRepository.deleteById(kodeMatkul);
        }
    }
}
