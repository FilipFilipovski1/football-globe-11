package Football.Globe1.footballglobe11.repository;

import Football.Globe1.footballglobe11.models.Footballer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FootballerRepository extends JpaRepository<Footballer,Long> {

    public List<Footballer> findBySurname(String surname);

    public List<Footballer> findBySurnameContaining(String surname);

    //public List<Footballer> findByNationalityNotNull(String nationality);

    public List<Footballer> findByAgent_AgentName(String agentName);

    public List<Footballer> findByNameAndSurname(String name,String surname);

    public List<Footballer> findByDateOfBirth(Date dateOfBirth);

//    @Query("SELECT f FROM Footballer f WHERE f.spouse=?1")
//    public Footballer getFootballerBySpouse(String spouse);
//
//    @Query("SELECT f.surname FROM Footballer f WHERE f.spouse=?1")
//    public String getSurnameBySpouse(String spouse);

    @Query(value = "SELECT f.surname FROM footballglobe11.footballer f where f.spouse=?1", nativeQuery = true)
    public String getSurnameBySpouseNative(String spouse);

    @Query(value = "SELECT f.surname FROM footballglobe11.footballer f where f.spouse=:spouse", nativeQuery = true)
    public String getSurnameBySpouseNativeParam(@Param("spouse") String spouse);

    @Modifying
    @Transactional
    @Query(value = "update footballglobe11.footballer f set f.position=?1 where f.surname=?2",nativeQuery = true)
    int updateFootballerSurname(String position,String surname);

    @Modifying
    @Transactional
    @Query(value = "update footballglobe11.footballer f set f.date_of_birth=?1 where f.surname=?2",nativeQuery = true)
    int updateFootballerDateOfBirth(Date dateOfBirth,String surname);


}