package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import java.net.URI;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private ModelMapper modelMapper;

    private WorldRecordRepository worldRecordRepository;

    private RecorderService recorderService;


    @Transactional
    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {

        Recorder recorder = recorderService.findRecorderById(command.getRecorderId());

        WorldRecord worldRecord = new WorldRecord(command.getDescription(), command.getValue(), command.getUnitOfMeasure(),
                command.getDateOfRecord());

        recorder.addWorldRecord(worldRecord);

        worldRecordRepository.save(worldRecord);

        return modelMapper.map(worldRecord, WorldRecordDto.class);
    }

    public BeatWorldRecordDto beatWorldRecord(Long id, BeatWorldRecordCommand command) {

        WorldRecord oldWorldRecord = worldRecordRepository.findById(id)
                .orElseThrow(() -> new RecorderNotFoundException(URI.create("worlrecord/not-found"), "World record not found"));

        Recorder newRecorder = recorderService.findRecorderById(command.getRecorderId());

        //BeatWorldRecordDto beatWorldRecordDto = new BeatWorldRecordDto()


        return null;
    }
}
