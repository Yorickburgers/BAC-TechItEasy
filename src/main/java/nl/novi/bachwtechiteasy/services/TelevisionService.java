package nl.novi.bachwtechiteasy.services;

import nl.novi.bachwtechiteasy.dtos.TelevisionDto;
import nl.novi.bachwtechiteasy.dtos.TelevisionInputDto;
import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.bachwtechiteasy.mappers.TelevisionMapper;
import nl.novi.bachwtechiteasy.models.Television;
import nl.novi.bachwtechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {

    @Autowired
    private final TelevisionRepository repos;

    @Autowired
    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public List<TelevisionDto> getTelevisions() {
        List<TelevisionDto> televisions = new ArrayList<>();
        repos.findAll().forEach(television -> televisions.add(TelevisionMapper.toTelevisionDto(television)));
        return televisions;
    }

    public TelevisionDto getTelevision(int id) {
        return TelevisionMapper.toTelevisionDto(repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found!")));
    }

    public TelevisionDto saveTelevision(TelevisionInputDto televisionDto) {
        Television television = TelevisionMapper.toTelevision(televisionDto);
        TelevisionMapper.toTelevisionDto(repos.save(television));
        return TelevisionMapper.toTelevisionDto(television);
    }

    public TelevisionDto updateTelevision(int id, TelevisionInputDto televisionInputDto) {
        Television currentTv = this.repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found!"));
        currentTv.setType(televisionInputDto.type);
        currentTv.setBrand(televisionInputDto.brand);
        currentTv.setPrice(televisionInputDto.price);
        currentTv.setAvailableSize(televisionInputDto.availableSize);
        currentTv.setRefreshRate(televisionInputDto.refreshRate);
        currentTv.setScreenType(televisionInputDto.screenType);
        currentTv.setScreenQuality(televisionInputDto.screenQuality);
        currentTv.setSmartTV(televisionInputDto.smartTV);
        currentTv.setWifi(televisionInputDto.wifi);
        currentTv.setVoiceControl(televisionInputDto.voiceControl);
        currentTv.setHdr(televisionInputDto.hdr);
        currentTv.setBluetooth(televisionInputDto.bluetooth);
        currentTv.setAmbiLight(televisionInputDto.ambiLight);
        currentTv.setOriginalStock(televisionInputDto.originalStock);
        currentTv.setSold(televisionInputDto.sold);
        return TelevisionMapper.toTelevisionDto(repos.save(currentTv));
    }

    public String deleteTelevision(int id) {
        repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found!"));
        repos.deleteById(id);
        return "Television " + id + " deleted!";
    }
}
