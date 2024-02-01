package Football.Globe1.footballglobe11.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tbl_league",uniqueConstraints=@UniqueConstraint(name = "nameOfTheLeagueId_unique",columnNames="name_of_the_league"))
public class League {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long leagueId;

    @Column(name="name_of_the_league",nullable = false,unique = true)
    private String nameOfTheLeague;

    @Basic(optional = false)
    private String country;

    @Column(nullable = false)
    private Integer numberOfClubs;

    //private List<Club> clubs;

}

