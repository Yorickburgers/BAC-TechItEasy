package nl.novi.bachwtechiteasy.services;

import nl.novi.bachwtechiteasy.dtos.RemoteControllerDto;
import nl.novi.bachwtechiteasy.dtos.RemoteControllerInputDto;
import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.bachwtechiteasy.mappers.RemoteControllerMapper;
import nl.novi.bachwtechiteasy.models.RemoteController;
import nl.novi.bachwtechiteasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteControllerService {
    private final RemoteControllerRepository repos;

    public RemoteControllerService(RemoteControllerRepository repos) {
        this.repos = repos;
    }

    public List<RemoteControllerDto> getRemoteControllers() {
        List<RemoteControllerDto> remoteControllers = new ArrayList<>();
        repos.findAll().forEach(remoteController -> remoteControllers.add(RemoteControllerMapper.toRemoteControllerDto(remoteController)));
        return remoteControllers;
    }

    public RemoteControllerDto getRemoteController(Long id) {
        return RemoteControllerMapper.toRemoteControllerDto(repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Remote Controller " + id + " not found!")));
    }

    public RemoteControllerDto saveRemoteController(RemoteControllerInputDto remoteControllerDto) {
        RemoteController remoteController = RemoteControllerMapper.toRemoteController(remoteControllerDto);
        RemoteControllerMapper.toRemoteControllerDto(repos.save(remoteController));
        return RemoteControllerMapper.toRemoteControllerDto(remoteController);
    }

    public RemoteControllerDto updateRemoteController(Long id, RemoteControllerInputDto wallBracketInputDto) {
        RemoteController currentRc = this.repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Remote Controller " + id + " not found!"));
        currentRc.setName(wallBracketInputDto.name);
        currentRc.setBrand(wallBracketInputDto.brand);
        currentRc.setBatteryType(wallBracketInputDto.batteryType);
        currentRc.setPrice(wallBracketInputDto.price);
        currentRc.setOriginalStock(wallBracketInputDto.originalStock);
        currentRc.setCompatibleWith(wallBracketInputDto.compatibleWith);

        return RemoteControllerMapper.toRemoteControllerDto(repos.save(currentRc));
    }

    public String deleteRemoteController(Long id) {
        repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Remote Controller " + id + " not found!"));
        repos.deleteById(id);
        return "Remote Controller " + id + " deleted!";
    }
}
