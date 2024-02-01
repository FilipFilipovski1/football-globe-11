package Football.Globe1.footballglobe11.controllers;

import Football.Globe1.footballglobe11.models.Footballer;
import Football.Globe1.footballglobe11.services.FootballerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FootballerController {

    @Autowired
    private FootballerService footballerService;

    @GetMapping("/footballers")
    public ResponseEntity<List<Footballer>> getAllFootballers() {
        return new ResponseEntity<>(footballerService.getAllFootballers(), HttpStatus.OK);
    }

    @PostMapping("/footballers")
    public ResponseEntity<Footballer> createFootballer(@RequestBody Footballer footballer) {
        return new ResponseEntity<>(footballerService.createFootballer(footballer), HttpStatus.CREATED);
    }

    @GetMapping("/footballers/{id}")
    public ResponseEntity<Footballer> getSingeFootballer(@PathVariable Long id) {
        return new ResponseEntity<>(footballerService.getSingleFootballer(id), HttpStatus.OK);
    }

    @PutMapping("/footballers/{id}")
    public ResponseEntity<Footballer> editFootballer(@RequestBody Footballer footballer,@PathVariable Long id) {
        footballer.setFootballerId(id);
        return new ResponseEntity<>(footballerService.createFootballer(footballer), HttpStatus.OK);
    }

    @DeleteMapping("/footballers/{id}")
    public ResponseEntity<HttpStatus> deleteFootballer(@PathVariable Long id) {
        footballerService.deleteFootballer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
