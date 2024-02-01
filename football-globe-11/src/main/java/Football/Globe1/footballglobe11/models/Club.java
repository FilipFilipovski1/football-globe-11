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
public class Club {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long clubId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String colours;

    @Column(nullable = false)
    private String country;

    //private League league;

//    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
//    private List<Footballer> footballers;



}

