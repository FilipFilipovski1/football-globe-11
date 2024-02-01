package Football.Globe1.footballglobe11.services;

import Football.Globe1.footballglobe11.models.Footballer;

import java.util.List;

public interface FootballerService {

    List<Footballer> getAllFootballers();

    Footballer createFootballer(Footballer musician);

    Footballer getSingleFootballer(Long id);

    void deleteFootballer(Long id);
}
