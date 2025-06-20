package nl.novi.bachwtechiteasy.services;

import nl.novi.bachwtechiteasy.dtos.CIModuleDto;
import nl.novi.bachwtechiteasy.dtos.CIModuleInputDto;
import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.bachwtechiteasy.mappers.CIModuleMapper;
import nl.novi.bachwtechiteasy.models.CIModule;
import nl.novi.bachwtechiteasy.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CIModuleService {
    private final CIModuleRepository repos;

    public CIModuleService(CIModuleRepository repos) {
        this.repos = repos;
    }

    public List<CIModuleDto> getCIModules() {
        List<CIModuleDto> ciModules = new ArrayList<>();
        repos.findAll().forEach(ciModule -> ciModules.add(CIModuleMapper.toCIModuleDto(ciModule)));
        return ciModules;
    }

    public CIModuleDto getCIModule(Long id) {
        return CIModuleMapper.toCIModuleDto(repos.findById(id).orElseThrow(() -> new RecordNotFoundException("CI-Module " + id + " not found!")));
    }

    public CIModuleDto saveCIModule(CIModuleInputDto ciModuleDto) {
        CIModule ciModule = CIModuleMapper.toCIModule(ciModuleDto);
        CIModuleMapper.toCIModuleDto(repos.save(ciModule));
        return CIModuleMapper.toCIModuleDto(ciModule);
    }

    public CIModuleDto updateCIModule(Long id, CIModuleInputDto ciModuleInputDto) {
        CIModule currentCI = this.repos.findById(id).orElseThrow(() -> new RecordNotFoundException("CI-Module " + id + " not found!"));
        currentCI.setName(ciModuleInputDto.name);
        currentCI.setPrice(ciModuleInputDto.price);
        currentCI.setType(ciModuleInputDto.type);

        return CIModuleMapper.toCIModuleDto(repos.save(currentCI));
    }

    public String deleteCIModule(Long id) {
        repos.findById(id).orElseThrow(() -> new RecordNotFoundException("CI-Module " + id + " not found!"));
        repos.deleteById(id);
        return "CI-Module " + id + " deleted!";
    }
}
