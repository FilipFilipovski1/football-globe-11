package Football.Globe1.footballglobe11.repository;

import Football.Globe1.footballglobe11.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FootballerRepositoryTest {

    @Autowired
    FootballerRepository footballerRepository;

    @Autowired
    SpouseRepository spouseRepository;

    @Test
    public void saveFootballer() throws ParseException {
        //Footballer footballer1=new Footballer("Filip","Filipovski","Macedonian", new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31"),"Right back");
        Footballer footballer2=Footballer.builder().name("Goran").surname("Pandev").nationality("Macedonian").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31")).position("Striker").build();
       //footballerRepository.save(footballer1);
        footballerRepository.save(footballer2);
    }

//    @Test
//    public void saveFootballerWithAgent() throws ParseException {
//        Agent agent = new Agent("Bozur", "Tomovic", "Serbian", new SimpleDateFormat("yyyy-MM-dd").parse("1978-03-31"));
//        Spouse spouse = Spouse.builder().name("Mitra").nationality("French").surname("Mitrova").profession("Model").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1978-03-31")).build();
//        Footballer footballer = Footballer.builder().name("Kime").nationality("Macedonian").surname("Tomson").position("Left Wing").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1988-05-31")).agent(agent).spouse(spouse).build();
//
//        footballerRepository.save(footballer);
//    }

    @Test
    public void findAllAndPrint(){
        List<Footballer> footballers=footballerRepository.findAll();
        System.out.println("List of footballers"+footballers);
    }

    @Test
    public void printFootballerBySurname(){
        List<Footballer> footballersWithSameSurname=footballerRepository.findBySurname("Filipovski");
        System.out.println("List of footballers by surname Filipovski: "+footballersWithSameSurname);
        System.out.println("Number of footballers with surname Filipovski: "+footballersWithSameSurname.size());

    }

    @Test
    public void printFootballerBySurnameContainingCharacters(){
        List<Footballer> footballersWithSurnameContainingCharacters=footballerRepository.findBySurnameContaining("Filipovski");
        System.out.println("List of footballers containing word Filip: "+ footballersWithSurnameContainingCharacters);
        System.out.println("Number of footballers containing word Filip: "+footballersWithSurnameContainingCharacters.size());
    }

    @Test
    public void printFootballerBasedOnGuardianName(){
        List<Footballer> footballersWithSameGuardianName=footballerRepository.findByAgent_AgentName("Tomas");
        System.out.println("List of footballers containing word Filip: "+ footballersWithSameGuardianName);
        System.out.println("Number of footballers containing word Filip: "+footballersWithSameGuardianName.size());
    }

    @Test
    public void printFootballerBasedOnNameAndSurname(){
        List<Footballer> footballersContainingNameAndSurname=footballerRepository.findByNameAndSurname("Filip","Filipovski");
        System.out.println("List of footballers containing Filip Filipovski: "+ footballersContainingNameAndSurname);
        System.out.println("Number of footballers containing Filip Filipovski: "+footballersContainingNameAndSurname.size());
    }

    @Test
    public void printFootballerByDateOfBirth() throws ParseException {
        Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-07");
        List<Footballer> footballersWithSameDateOfBirth = footballerRepository.findByDateOfBirth(dateOfBirth);
        System.out.println("List of footballers by date of birth 1998-05-07: " + footballersWithSameDateOfBirth);
        System.out.println("Number of footballers with date of birth 1998-05-07: " + footballersWithSameDateOfBirth.size());
    }

//    @Test
//    public void printFootballerBySpouse()  {
//        Footballer footballersWithSpouseProvided = footballerRepository.getFootballerBySpouse("Tamara");
//        System.out.println("Footballer with spouse Tamara: " + footballersWithSpouseProvided);
//    }
//
//    @Test
//    public void printFootballerSurnameBySpouse()  {
//        String footballersSurnamesWithSpouseProvided = footballerRepository.getSurnameBySpouse("Tamara");
//        System.out.println("Footballer with spouse Tamara: " + footballersSurnamesWithSpouseProvided);
//    }

    @Test
    public void printFootballerSurnameBySpouseNative(){
        String footballer=footballerRepository.getSurnameBySpouseNative("Tamara");
        System.out.println("Footballer surname with native query= "+footballer);
    }

    @Test
    public void printFootballerSurnameBySpouseNative2(){
        String footballer=footballerRepository.getSurnameBySpouseNativeParam("Tamara");
        System.out.println("Footballer surname with native query= "+footballer);
    }

    @Test
    public void updateFootballerSurname(){
        footballerRepository.updateFootballerSurname("Goalkeeper","Filipovikj");
    }

    @Test
    public void updateFootballerDateOfBirth() throws ParseException {
        Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse("1998-08-08");
        footballerRepository.updateFootballerDateOfBirth(dateOfBirth,"Filipovikj");
    }

    @Test
    public void printFootballers(){
        List<Footballer> footballers=footballerRepository.findAll();
        System.out.println("List of footballers: "+footballers);
    }

    @Test
    public void createFootballerWithSpouse() throws ParseException {
        Agent agent=new Agent("Dzoni","Mitrovic","Serbian",new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31"));
        Spouse spouse=Spouse.builder().name("Petra").surname("Krte").profession("Model").nationality("Slovenian").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31")).build();
        Footballer footballer = Footballer.builder()
                .name("Dimitar")
                .nationality("Macedonian")
                .surname("Tomson")
                .position("Left Wing")
                .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-31"))
                .agent(agent)
                .spouse(spouse)
                .build();

        footballerRepository.save(footballer);
    }
    @Test
    public void printFootballerWithSpouse(){
        List<Footballer> footballerList=footballerRepository.findAll();
        System.out.println("List of all spouses: "+footballerList);
    }

    @Test
    public void saveFootballerWithClub() throws ParseException {
        Club club=Club.builder().name("Benfica").colours("Red").country("England").build();
        Agent agent=new Agent("Saud","Tomovic","Serbian",new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31"));
        Spouse spouse=Spouse.builder().name("Sara").surname("Krte").profession("Model").nationality("Slovenian").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31")).build();
        Footballer footballer = Footballer.builder()
                .name("Jamal")
                .nationality("Afghanistan")
                .surname("Tomson")
                .position("Left Wing")
                .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1988-05-31"))
                .agent(agent)
                .spouse(spouse)
                .club(club)
                .build();

        footballerRepository.save(footballer);
    }

    @Test
    public void findAllPagination(){

        org.springframework.data.domain.Pageable firstPage= PageRequest.of(0,3);
        org.springframework.data.domain.Pageable secondPage=  PageRequest.of(1,3);
        Page<Footballer> footballersOnFirstPage = footballerRepository.findAll(firstPage);
        List<Footballer> footballers = footballersOnFirstPage.getContent();
        long totalElements = footballersOnFirstPage.getTotalElements();
        int totalPages = footballersOnFirstPage.getTotalPages();
        System.out.println("Page1: " + footballersOnFirstPage);
        System.out.println("Footballers: " + footballers);
        System.out.println("Total elements: " + totalElements);
        System.out.println("Total pages: " + totalPages);

    }

    @Test
    public void findAllSorting() {
        org.springframework.data.domain.Pageable sortByNationality = PageRequest.of(0, 2, Sort.by("nationality"));
        org.springframework.data.domain.Pageable sortBySurname = PageRequest.of(0, 2, Sort.by("surname").descending());
        org.springframework.data.domain.Pageable sortByNationalityAndSurnameDesc = PageRequest.of(0, 2, Sort.by("nationality").descending().and(Sort.by("surname")));
        List<Footballer> footballers = footballerRepository.findAll(sortByNationality).getContent();
        System.out.println("Footballers: " + footballers);
    }

    @Test
    public void saveFootballerWithSponsors() throws ParseException {
        Club club=Club.builder().name("Roma").colours("Red").country("Italy").build();
        Agent agent=new Agent("Johan","Tomovic","Serbian",new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31"));
        Spouse spouse=Spouse.builder().name("Joana").surname("Krte").profession("Model").nationality("Slovenian").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31")).build();
        Sponsor sponsor=Sponsor.builder().name("ITGMA").build();
        Footballer footballer = Footballer.builder()
                .name("Martin")
                .nationality("Macedonia")
                .surname("Tomson")
                .position("Right Wing")
                .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-01-31"))
                .agent(agent)
                .spouse(spouse)
                .club(club)
                .build();
        footballer.addSponsor(sponsor);
        footballerRepository.save(footballer);
    }

    @Test
    public void saveFootballerWithSponsorsSecondWay() throws ParseException {
        Club club=Club.builder().name("Inter").colours("Red").country("Italy").build();
        Agent agent=new Agent("Bruce","Tomovic","Serbian",new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31"));
        Spouse spouse=Spouse.builder().name("Kerry").surname("Krte").profession("Model").nationality("Slovenian").dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-03-31")).build();
        Sponsor sponsor=Sponsor.builder().name("Vitaminka").build();
        List<Sponsor> sponsorsList = new ArrayList<>();
        sponsorsList.add(sponsor);
        Footballer footballer = Footballer.builder()
                .name("Jack")
                .nationality("England")
                .surname("Tomson")
                .position("Right Wing")
                .dateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1998-01-31"))
                .agent(agent)
                .spouse(spouse)
                .club(club)
                .sponsors(sponsorsList)
                .build();
        footballerRepository.save(footballer);
    }

}