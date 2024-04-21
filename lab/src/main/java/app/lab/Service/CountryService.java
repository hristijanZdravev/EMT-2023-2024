package app.lab.Service;

import app.lab.Model.Country;
import app.lab.Model.DTO.CountryDTO;
import app.lab.Model.DTO.HostDTO;
import app.lab.Model.Host;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();
    Optional<Country> findById(Long id);

    Optional<Country> create(CountryDTO countryDTO);

    Optional<Country> edit(Long id, CountryDTO countryDTO);
    Optional<Country> delete(Long id);
}
