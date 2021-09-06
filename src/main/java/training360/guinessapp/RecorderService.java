package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.net.URI;
import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {

    private RecorderRepository recorderRepository;

    private ModelMapper modelMapper;

    public List<RecorderShortDto> listRecorders() {
        List<Recorder> recorders = recorderRepository.listRecordersWithCondition();
        return recorders.stream()
                .map(recorder -> modelMapper.map(recorder, RecorderShortDto.class))
                .toList();
    }

    public RecorderDto createRecorder(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        recorderRepository.save(recorder);
        return modelMapper.map(recorder, RecorderDto.class);
    }

    public Recorder findRecorderById(Long recorderId) {
        return recorderRepository.findById(recorderId).orElseThrow(() -> new RecorderNotFoundException(URI.create("recorder/not-found"), "Recorder not found"));
    }
}
