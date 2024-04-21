package app.lab.Model;

import app.lab.Model.DTO.HousingDTO;
import app.lab.Model.Enum.HousingCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Housing {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;

    @Enumerated(EnumType.STRING)
    private HousingCategory category;

    @ManyToOne
    private Host host;

    private Integer numRooms;

    private Boolean isRented;

    public Housing() {
    }

    public Housing(String name, HousingCategory category, Host host, Integer numRooms, Boolean isRented) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.isRented = isRented;
    }
}
