package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecordDto {

    private String description;

    private String unitOfMeasure;

    private String oldRecorderName;

    private Double oldRecordValue;

    private String newRecorderName;

    private Double newRecordValue;

    private Double recordDifference;


}
