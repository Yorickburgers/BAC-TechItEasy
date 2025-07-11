package nl.novi.bachwtechiteasy.services;

import nl.novi.bachwtechiteasy.dtos.RemoteControllerDto;
import nl.novi.bachwtechiteasy.dtos.RemoteControllerInputDto;
import nl.novi.bachwtechiteasy.dtos.TelevisionDto;
import nl.novi.bachwtechiteasy.dtos.TelevisionInputDto;
import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.bachwtechiteasy.mappers.TelevisionMapper;
import nl.novi.bachwtechiteasy.models.CIModule;
import nl.novi.bachwtechiteasy.models.RemoteController;
import nl.novi.bachwtechiteasy.models.Television;
import nl.novi.bachwtechiteasy.models.WallBracket;
import nl.novi.bachwtechiteasy.repositories.CIModuleRepository;
import nl.novi.bachwtechiteasy.repositories.RemoteControllerRepository;
import nl.novi.bachwtechiteasy.repositories.TelevisionRepository;
import nl.novi.bachwtechiteasy.repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository repos;
    private final RemoteControllerRepository remoteRepos;
    private final CIModuleRepository ciRepos;
    private final WallBracketRepository wbRepos;

    public TelevisionService(TelevisionRepository repos, RemoteControllerRepository remoteRepos, CIModuleRepository ciRepos, WallBracketRepository wbRepos) {
        this.repos = repos;
        this.remoteRepos = remoteRepos;
        this.ciRepos = ciRepos;
        this.wbRepos = wbRepos;
    }

    public List<TelevisionDto> getTelevisions() {
        List<TelevisionDto> televisions = new ArrayList<>();
        repos.findAll().forEach(television -> televisions.add(TelevisionMapper.toTelevisionDto(television)));

        return televisions;
    }

    public TelevisionDto getTelevision(Long id) {
        return TelevisionMapper.toTelevisionDto(repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found!")));
    }

    public TelevisionDto saveTelevision(TelevisionInputDto televisionDto) {
        Television television = TelevisionMapper.toTelevision(televisionDto);
        TelevisionMapper.toTelevisionDto(repos.save(television));

        return TelevisionMapper.toTelevisionDto(television);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto televisionInputDto) {
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

    public String deleteTelevision(Long id) {
        repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found!"));
        repos.deleteById(id);

        return "Television " + id + " deleted!";
    }

    public TelevisionDto assignRemoteControllerToTelevision(Long remoteId, Long TVid) {
        Television tv = repos.findById(TVid).orElseThrow(() -> new RecordNotFoundException("Television " + TVid + " not found!"));
        RemoteController remote = remoteRepos.findById(remoteId).orElseThrow(() -> new RecordNotFoundException("Remote Controller " + remoteId + " not found!"));
        tv.setRemoteController(remote);

        return TelevisionMapper.toTelevisionDto(repos.save(tv));
    }

    public TelevisionDto assignCIModuleToTelevision(Long ciModuleId, Long TvId) {
        Television tv = repos.findById(TvId).orElseThrow(() -> new RecordNotFoundException("Television " + TvId + " not found!"));
        CIModule ci = ciRepos.findById(ciModuleId).orElseThrow(() -> new RecordNotFoundException("Remote Controller " + ciModuleId + " not found!"));
        tv.setCiModule(ci);

        return TelevisionMapper.toTelevisionDto(repos.save(tv));
    }

    public TelevisionDto assignWallBracketToTelevision(Long wbId, Long TvId) {
        Television tv = repos.findById(TvId).orElseThrow(() -> new RecordNotFoundException("Television " + TvId + " not found!"));
        WallBracket wb = wbRepos.findById(wbId).orElseThrow(() -> new RecordNotFoundException("Remote Controller " + wbId + " not found!"));
        tv.getWallBrackets().add(wb);

        return TelevisionMapper.toTelevisionDto(repos.save(tv));
    }
}
