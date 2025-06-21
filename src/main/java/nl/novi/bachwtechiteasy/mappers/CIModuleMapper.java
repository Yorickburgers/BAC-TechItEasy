package nl.novi.bachwtechiteasy.mappers;

import nl.novi.bachwtechiteasy.dtos.CIModuleDto;
import nl.novi.bachwtechiteasy.dtos.CIModuleInputDto;
import nl.novi.bachwtechiteasy.models.CIModule;

public class CIModuleMapper {
    public static CIModuleDto toCIModuleDto(CIModule ci) {
        if (ci == null) return null;

        CIModuleDto dto = new CIModuleDto();

        dto.id = ci.getId();
        dto.name = ci.getName();
        dto.price = ci.getPrice();
        dto.type = ci.getType();

        return dto;
    }

    public static CIModule toCIModule(CIModuleInputDto ciModuleDto) {
        CIModule ci = new CIModule();

        ci.setName(ciModuleDto.name);
        ci.setPrice(ciModuleDto.price);
        ci.setType(ciModuleDto.type);

        return ci;
    }
}
