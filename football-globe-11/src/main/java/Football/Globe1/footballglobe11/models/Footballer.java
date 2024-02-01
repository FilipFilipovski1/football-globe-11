package Football.Globe1.footballglobe11.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "spouse")
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "football_sequence")
    @SequenceGenerator(name = "football_sequence", sequenceName = "football_sequence", allocationSize = 1)
    private Long footballerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String position;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="spouse_id", referencedColumnName = "spouseId")
    private Spouse spouse;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="club_id",referencedColumnName="clubId")
    private Club club;

    @Column(nullable = false)
    @Embedded
    private Agent agent = new Agent();

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name="footballer_sponsor_map",joinColumns = @JoinColumn(name="footballer_id",referencedColumnName="footballerId"),
            inverseJoinColumns=@JoinColumn(name="sponsor_id",referencedColumnName="sponsorId"))
    private List<Sponsor> sponsors;

    public void addSponsor(Sponsor sponsor){
        if(sponsors==null){
            sponsors= new ArrayList<>();
        }
        sponsors.add(sponsor);
    }

}





