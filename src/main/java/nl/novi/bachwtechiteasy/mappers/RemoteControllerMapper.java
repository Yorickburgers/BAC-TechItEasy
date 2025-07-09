package nl.novi.bachwtechiteasy.mappers;

import nl.novi.bachwtechiteasy.dtos.RemoteControllerDto;
import nl.novi.bachwtechiteasy.dtos.RemoteControllerInputDto;
import nl.novi.bachwtechiteasy.models.RemoteController;

public class RemoteControllerMapper {
    public static RemoteControllerDto toRemoteControllerDto(RemoteController remote) {
        if (remote == null) return null;

        RemoteControllerDto dto = new RemoteControllerDto();
        dto.id = remote.getId();
        dto.name = remote.getName();
        dto.price = remote.getPrice();
        dto.brand = remote.getBrand();
        dto.batteryType = remote.getBatteryType();
        dto.compatibleWith = remote.getCompatibleWith();
        dto.originalStock = remote.getOriginalStock();

        return dto;
    }

    public static RemoteController toRemoteController(RemoteControllerInputDto remoteControllerDto) {
        RemoteController remote = new RemoteController();

        remote.setName(remoteControllerDto.name);
        remote.setPrice(remoteControllerDto.price);
        remote.setBrand(remoteControllerDto.brand);
        remote.setBatteryType(remoteControllerDto.batteryType);
        remote.setCompatibleWith(remoteControllerDto.compatibleWith);
        remote.setOriginalStock(remoteControllerDto.originalStock);

        return remote;
    }
}
