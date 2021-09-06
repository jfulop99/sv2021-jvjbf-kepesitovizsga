package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/worldrecords")
public class WorldRecordController {

    private WorldRecordService worldRecordService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto createWorldRecord(@Valid @RequestBody WorldRecordCreateCommand command){
        return worldRecordService.createWorldRecord(command);
    }

    @PutMapping("/{id}/beatrecords")
    public BeatWorldRecordDto beatWorldRecord(@PathVariable Long id, @Valid @RequestBody BeatWorldRecordCommand command){
        return worldRecordService.beatWorldRecord(id, command);
    }

}
