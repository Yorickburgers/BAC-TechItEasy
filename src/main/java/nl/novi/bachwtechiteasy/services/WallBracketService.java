package nl.novi.bachwtechiteasy.services;

import nl.novi.bachwtechiteasy.dtos.WallBracketDto;
import nl.novi.bachwtechiteasy.dtos.WallBracketInputDto;
import nl.novi.bachwtechiteasy.exceptions.RecordNotFoundException;
import nl.novi.bachwtechiteasy.mappers.WallBracketMapper;
import nl.novi.bachwtechiteasy.models.WallBracket;
import nl.novi.bachwtechiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {
    private final WallBracketRepository repos;

    public WallBracketService(WallBracketRepository repos) {
        this.repos = repos;
    }

    public List<WallBracketDto> getWallBrackets() {
        List<WallBracketDto> wallBrackets = new ArrayList<>();
        repos.findAll().forEach(wallBracket -> wallBrackets.add(WallBracketMapper.toWallBracketDto(wallBracket)));
        return wallBrackets;
    }

    public WallBracketDto getWallBracket(Long id) {
        return WallBracketMapper.toWallBracketDto(repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Wall Bracket " + id + " not found!")));
    }

    public WallBracketDto saveWallBracket(WallBracketInputDto wallBracketDto) {
        WallBracket wallBracket = WallBracketMapper.toWallBracket(wallBracketDto);
        WallBracketMapper.toWallBracketDto(repos.save(wallBracket));
        return WallBracketMapper.toWallBracketDto(wallBracket);
    }

    public WallBracketDto updateWallBracket(Long id, WallBracketInputDto wallBracketInputDto) {
        WallBracket currentWb = this.repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Wall Bracket " + id + " not found!"));
        currentWb.setName(wallBracketInputDto.name);
        currentWb.setAdjustable(wallBracketInputDto.adjustable);
        currentWb.setPrice(wallBracketInputDto.price);
        currentWb.setSize(wallBracketInputDto.size);

        return WallBracketMapper.toWallBracketDto(repos.save(currentWb));
    }

    public String deleteWallBracket(Long id) {
        repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Wall Bracket " + id + " not found!"));
        repos.deleteById(id);
        return "Wall Bracket " + id + " deleted!";
    }
}
