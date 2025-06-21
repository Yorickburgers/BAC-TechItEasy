package nl.novi.bachwtechiteasy.mappers;

import nl.novi.bachwtechiteasy.dtos.TelevisionDto;
import nl.novi.bachwtechiteasy.dtos.TelevisionInputDto;
import nl.novi.bachwtechiteasy.models.Television;

public class TelevisionMapper {
    public static TelevisionDto toTelevisionDto(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.id = television.getId();
        dto.type = television.getType();
        dto.brand = television.getBrand();
        dto.price = television.getPrice();
        dto.availableSize = television.getAvailableSize();
        dto.refreshRate = television.getRefreshRate();
        dto.screenType = television.getScreenType();
        dto.screenQuality = television.getScreenQuality();
        dto.smartTV = television.isSmartTV();
        dto.wifi = television.isWifi();
        dto.voiceControl = television.isVoiceControl();
        dto.hdr = television.isHdr();
        dto.bluetooth = television.isBluetooth();
        dto.ambiLight = television.isAmbiLight();
        dto.originalStock = television.getOriginalStock();
        dto.sold = television.getSold();
        dto.remoteController = RemoteControllerMapper.toRemoteControllerDto(television.getRemoteController());
        dto.ciModule = CIModuleMapper.toCIModuleDto(television.getCiModule());

        return dto;
    }

    public static Television toTelevision(TelevisionInputDto televisionDto) {
        Television tv = new Television();

        tv.setType(televisionDto.type);
        tv.setBrand(televisionDto.brand);
        tv.setPrice(televisionDto.price);
        tv.setAvailableSize(televisionDto.availableSize);
        tv.setRefreshRate(televisionDto.refreshRate);
        tv.setScreenType(televisionDto.screenType);
        tv.setScreenQuality(televisionDto.screenQuality);
        tv.setSmartTV(televisionDto.smartTV);
        tv.setWifi(televisionDto.wifi);
        tv.setVoiceControl(televisionDto.voiceControl);
        tv.setHdr(televisionDto.hdr);
        tv.setBluetooth(televisionDto.bluetooth);
        tv.setAmbiLight(televisionDto.ambiLight);
        tv.setOriginalStock(televisionDto.originalStock);
        tv.setSold(televisionDto.sold);
        return tv;
    }
}
