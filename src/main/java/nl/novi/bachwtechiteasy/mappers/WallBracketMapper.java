package nl.novi.bachwtechiteasy.mappers;

import nl.novi.bachwtechiteasy.dtos.WallBracketDto;
import nl.novi.bachwtechiteasy.dtos.WallBracketInputDto;
import nl.novi.bachwtechiteasy.models.WallBracket;

public class WallBracketMapper {
    public static WallBracketDto toWallBracketDto(WallBracket wb) {
        WallBracketDto dto = new WallBracketDto();
        dto.id = wb.getId();
        dto.name = wb.getName();
        dto.price = wb.getPrice();
        dto.adjustable = wb.getAdjustable();
        dto.size = wb.getSize();

        return dto;
    }

    public static WallBracket toWallBracket(WallBracketInputDto wallBracketDto) {
        WallBracket wb = new WallBracket();

        wb.setAdjustable(wallBracketDto.adjustable);
        wb.setSize(wallBracketDto.size);
        wb.setPrice(wallBracketDto.price);
        wb.setName(wallBracketDto.name);

        return wb;
    }
}
