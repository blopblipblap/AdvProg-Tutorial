package csui.advpro2021.tais.repository;

import csui.advpro2021.tais.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, String> {
    Mahasiswa findByNpm(String npm);
}
