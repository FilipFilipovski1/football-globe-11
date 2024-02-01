package Football.Globe1.footballglobe11.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Agent {

    @Column(nullable = false)
    private String agentName;

    @Column(nullable = false)
    private String agentSurname;

    @Column(nullable = false)
    private String agentNationality;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date agentDateOfBirth;




    //private List<Footballer> footballers;

}


