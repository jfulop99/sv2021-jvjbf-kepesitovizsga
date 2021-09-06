package training360.guinessapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "recorder", cascade = CascadeType.ALL)
    private List<WorldRecord> worldRecords;

    public void addWorldRecord(WorldRecord worldRecord){
        if (worldRecords == null){
            worldRecords = new ArrayList<>();
        }
        worldRecord.setRecorder(this);
    }

    public Recorder(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
