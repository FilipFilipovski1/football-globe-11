package Football.Globe1.footballglobe11.repository;

import Football.Globe1.footballglobe11.models.Spouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpouseRepository extends JpaRepository<Spouse,Long> {


}
