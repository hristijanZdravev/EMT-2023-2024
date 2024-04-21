package app.lab.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Host {

    @Id
    @GeneratedValue
     private Long Id;

    private String name;

    private String surname;

    @ManyToOne
    private Country country;

    public Host() {
    }

    public Host(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
