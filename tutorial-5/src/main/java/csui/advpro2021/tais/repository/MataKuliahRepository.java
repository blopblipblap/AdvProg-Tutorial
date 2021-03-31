package csui.advpro2021.tais.repository;

import csui.advpro2021.tais.model.MataKuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MataKuliahRepository extends JpaRepository<MataKuliah, String> {
    MataKuliah findByKodeMatkul(String kodeMatkul);
}