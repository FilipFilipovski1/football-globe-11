package Football.Globe1.footballglobe11.repository;

import Football.Globe1.footballglobe11.models.Agent;
import Football.Globe1.footballglobe11.models.Club;
import Football.Globe1.footballglobe11.models.Footballer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClubRepositoryTest {

    @Autowired
    ClubRepository clubRepository;

    @Test
    public void saveClub() throws ParseException {
        Agent a1=Agent.builder().agentName("Tole").agentNationality("Macedonian").agentSurname("Toledov").agentDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-07")).build();
        Footballer footballer1=Footballer.builder().nationality("Macedonian").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-07")).position("Striker").surname("Bransnarov").name("Panko").agent(a1).build();
        Footballer footballer2=Footballer.builder().nationality("Macedonian").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-07")).position("Striker").surname("Temov").name("Lazar").agent(a1).build();
     //Club club=Club.builder().name("Arsenal").colours("Red").country("England").footballers(List.of(footballer1,footballer2)).build();
      //clubRepository.save(club);
    }
}