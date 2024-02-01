package Football.Globe1.footballglobe11.services;

import Football.Globe1.footballglobe11.models.Club;
import Football.Globe1.footballglobe11.models.Footballer;
import Football.Globe1.footballglobe11.models.Sponsor;
import Football.Globe1.footballglobe11.models.Spouse;
import Football.Globe1.footballglobe11.repository.ClubRepository;
import Football.Globe1.footballglobe11.repository.FootballerRepository;
import Football.Globe1.footballglobe11.repository.SponsorRepository;
import Football.Globe1.footballglobe11.repository.SpouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FootballerServiceImpl implements FootballerService {

    @Autowired
    private FootballerRepository footballerRepository;
    @Autowired
    private SpouseRepository spouseRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private SponsorRepository sponsorRepository;

    @Override
    public List<Footballer> getAllFootballers() {
        return footballerRepository.findAll();
    }

    @Override
    public Footballer createFootballer(Footballer footballer) {
        Club club = footballer.getClub();
        Spouse spouse=footballer.getSpouse();
        spouseRepository.save(spouse);
        clubRepository.save(club);

        List<Sponsor> sponsors = footballer.getSponsors();
        List<Sponsor> savedSponsors = new ArrayList<>();

        if (sponsors != null && !sponsors.isEmpty()) {
            for (Sponsor sponsor : sponsors) {
                Sponsor existingSponsor = sponsorRepository.findByName(sponsor.getName());

                if (existingSponsor != null) {
                    savedSponsors.add(existingSponsor);
                } else {
                    savedSponsors.add(sponsorRepository.save(sponsor));
                }
            }
        }

        footballer.setClub(club);
        footballer.setSpouse(spouse);
        footballer.setSponsors(savedSponsors);
        return footballerRepository.save(footballer);
    }

    @Override
    public Footballer getSingleFootballer(Long id) {
        Optional<Footballer> footballer=footballerRepository.findById(id);
        if(footballer.isPresent()) {
            return footballer.get();
        }
        else {
            throw new RuntimeException("Footballer is not found");
        }

    }

    @Override
    public void deleteFootballer(Long id) {
        footballerRepository.deleteById(id);

    }
}
