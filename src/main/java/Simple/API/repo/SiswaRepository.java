package Simple.API.repo;

import Simple.API.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiswaRepository
        extends JpaRepository<SiswaEntity, Long> {

    @Query("SELECT s FROM SiswaEntity s WHERE s.nisn = ?1")
    Optional<SiswaEntity> findStudentByNisn(Integer nisn);
}

