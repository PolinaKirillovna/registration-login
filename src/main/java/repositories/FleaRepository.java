package repositories;



import entitities.Flea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FleaRepository extends JpaRepository<Flea, Long> {
    List<Flea> findByName(String name);
}
