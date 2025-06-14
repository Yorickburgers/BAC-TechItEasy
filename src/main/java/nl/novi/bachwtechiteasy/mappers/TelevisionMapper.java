package nl.novi.bachwtechiteasy.mappers;

import nl.novi.bachwtechiteasy.dtos.TelevisionDto;
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

        return dto;
    }
}
