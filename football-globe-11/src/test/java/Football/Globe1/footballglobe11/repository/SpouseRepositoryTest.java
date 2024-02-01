package Football.Globe1.footballglobe11.repository;

import Football.Globe1.footballglobe11.models.Agent;
import Football.Globe1.footballglobe11.models.Footballer;
import Football.Globe1.footballglobe11.models.Spouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpouseRepositoryTest {

    @Autowired
    public SpouseRepository spouseRepository;


//    @Test
//    public void createSpouse() throws ParseException {
//        Agent agent=new Agent("Trubar","Tomovic","Serbian",new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31"));
//        Footballer footballer = Footballer.builder()
//                .name("Trubarko")
//                .nationality("Macedonian")
//                .surname("Tomson")
//                .position("Left Wing")
//                .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1988-05-31"))
//                .agent(agent)
//                .build();
//
//        Spouse spouse=Spouse.builder().name("Trubarka").surname("Krte").profession("Model").nationality("Slovenian").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31")).footballer(footballer).build();
//        spouseRepository.save(spouse);
//    }
    @Test
    public void printAllSpouses(){
        List<Spouse> spousesList=spouseRepository.findAll();
        System.out.println("List of all spouses: "+spousesList);
    }
}

