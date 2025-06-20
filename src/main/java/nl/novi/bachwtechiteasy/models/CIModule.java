package nl.novi.bachwtechiteasy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ci_modules")
public class CIModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Double price;

    public CIModule(String name, String type, Double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public CIModule() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
