package nl.novi.bachwtechiteasy.services;

import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.bachwtechiteasy.models.Television;
import nl.novi.bachwtechiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    @Autowired
    private final TelevisionRepository repos;

    @Autowired
    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public List<Television> getTelevisions() {
        return repos.findAll();
    }

    public Television getTelevision(int id) {
        return repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found!"));
    }

    public Television saveTelevision(Television television) {
        // dto naar entity
        //
        return this.repos.save(television);
    }

    public Television updateTelevision(int id, Television television) {
        Television currentTv = this.repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found!"));
        currentTv.setType(television.getType());
        currentTv.setBrand(television.getBrand());
        currentTv.setPrice(television.getPrice());
        currentTv.setAvailableSize(television.getAvailableSize());
        currentTv.setRefreshRate(television.getRefreshRate());
        currentTv.setScreenType(television.getScreenType());
        currentTv.setScreenQuality(television.getScreenQuality());
        currentTv.setSmartTV(television.isSmartTV());
        currentTv.setWifi(television.isWifi());
        currentTv.setVoiceControl(television.isVoiceControl());
        currentTv.setHdr(television.isHdr());
        currentTv.setBluetooth(television.isBluetooth());
        currentTv.setAmbiLight(television.isAmbiLight());
        currentTv.setOriginalStock(television.getOriginalStock());
        currentTv.setSold(television.getSold());
        return this.repos.save(currentTv);
    }

    public String deleteTelevision(int id) {
        Television tv = this.repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found!"));
        this.repos.deleteById(id);
        return "Television " + id + " deleted!";
    }
}
