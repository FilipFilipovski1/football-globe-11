package Football.Globe1.footballglobe11.repository;

import Football.Globe1.footballglobe11.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
}
