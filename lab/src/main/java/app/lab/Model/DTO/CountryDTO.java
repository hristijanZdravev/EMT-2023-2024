package app.lab.Model.DTO;

import lombok.Data;

@Data
public class CountryDTO {
    private String name;

    private String continent;

    public CountryDTO(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
