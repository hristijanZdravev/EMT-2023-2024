package app.lab.Model.DTO;

import app.lab.Model.Enum.HousingCategory;
import app.lab.Model.Host;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class HousingDTO {

    private String name;

    private HousingCategory category;

    private Long hostId;

    private Integer numRooms;
    public HousingDTO(String name, HousingCategory category, Long hostID, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.hostId = hostID;
        this.numRooms = numRooms;
    }
}
