package Football.Globe1.footballglobe11.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Spouse {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long spouseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String profession;

    @Column(nullable = false)
    private Date dateOfBirth;

//    @OneToOne(mappedBy = "spouse")
//    private Footballer footballer;

}

