package nl.novi.bachwtechiteasy.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private Double price;
    private Double availableSize;
    private int refreshRate;
    private String screenType;
    private String screenQuality;
    private boolean smartTV;
    private boolean wifi;
    private boolean voiceControl;
    private boolean hdr;
    private boolean bluetooth;
    private boolean ambiLight;
    private Integer originalStock;
    private Integer sold;

    @OneToOne
    RemoteController remoteController;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ci_module_id")
    private CIModule ciModule;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "televisions_wall_brackets", joinColumns = @JoinColumn(name = "television"), inverseJoinColumns = @JoinColumn(name = "wallbracket"))
    private List<WallBracket> wallBrackets = new ArrayList<WallBracket>();

    public Television() { }

    public Television(String type, String brand, Double price, Double availableSize, int refreshRate, String screenType, String screenQuality, boolean smartTV, boolean wifi, boolean voiceControl, boolean hdr, boolean bluetooth, boolean ambiLight, Integer originalStock, Integer sold) {
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTV = smartTV;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
    }



    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean isSmartTV() {
        return smartTV;
    }

    public void setSmartTV(boolean smartTV) {
        this.smartTV = smartTV;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public boolean isHdr() {
        return hdr;
    }

    public void setHdr(boolean hdr) {
        this.hdr = hdr;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    public CIModule getCiModule() {
        return ciModule;
    }

    public void setCiModule(CIModule ciModule) {
        this.ciModule = ciModule;
    }

    public List<WallBracket> getWallBrackets() {
        return wallBrackets;
    }

    public void setWallBrackets(List<WallBracket> wallBrackets) {
        this.wallBrackets = wallBrackets;
    }
}
