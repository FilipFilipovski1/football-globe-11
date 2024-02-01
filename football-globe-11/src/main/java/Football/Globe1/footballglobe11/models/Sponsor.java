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
public class Sponsor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long sponsorId;

    @Column(nullable = false)
    private String name;

    //private List<Footballer> footballers;
}

