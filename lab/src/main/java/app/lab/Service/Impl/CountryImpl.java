package app.lab.Service.Impl;

import app.lab.Model.Country;
import app.lab.Model.DTO.CountryDTO;
import app.lab.Model.Excepetion.NotFound;
import app.lab.Model.Host;
import app.lab.Repository.CountryRepository;
import app.lab.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.of(countryRepository.findById(id).orElseThrow(NotFound::new));
    }

    @Override
    public Optional<Country> create(CountryDTO countryDTO) {
        Country country = new Country(countryDTO.getName(),countryDTO.getContinent());
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, CountryDTO countryDTO) {
        Country country = findById(id).get();
        country.setName(countryDTO.getName());
        country.setContinent(country.getContinent());
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> delete(Long id) {
        Country country = findById(id).get();
        countryRepository.delete(country);
        return Optional.of(country);
    }
}
