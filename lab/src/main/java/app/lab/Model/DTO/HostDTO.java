package app.lab.Model.DTO;

import app.lab.Model.Country;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class HostDTO {

    private String name;

    private String surname;

    private Long countryId;

    public HostDTO(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }
}
