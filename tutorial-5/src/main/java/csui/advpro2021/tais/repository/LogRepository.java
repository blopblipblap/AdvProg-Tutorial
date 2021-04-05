package csui.advpro2021.tais.repository;

import csui.advpro2021.tais.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer>{
    Log findByIdLog(Integer idLog);
}
