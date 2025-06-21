package nl.novi.bachwtechiteasy.dtos;

import nl.novi.bachwtechiteasy.models.WallBracket;

import java.util.List;

public class TelevisionDto {
    public Long id;
    public String type;
    public String brand;
    public Double price;
    public Double availableSize;
    public int refreshRate;
    public String screenType;
    public String screenQuality;
    public boolean smartTV;
    public boolean wifi;
    public boolean voiceControl;
    public boolean hdr;
    public boolean bluetooth;
    public boolean ambiLight;
    public Integer originalStock;
    public Integer sold;

    public RemoteControllerDto remoteController;
    public CIModuleDto ciModule;
    public List<WallBracketDto> wallBrackets;
}
