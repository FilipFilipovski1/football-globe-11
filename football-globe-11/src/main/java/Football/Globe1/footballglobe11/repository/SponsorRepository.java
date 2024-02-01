package Football.Globe1.footballglobe11.repository;

import Football.Globe1.footballglobe11.models.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
    Sponsor findByName(String name);
}
