package app.lab.Service.Impl;

import app.lab.Model.Country;
import app.lab.Model.DTO.HostDTO;
import app.lab.Model.Excepetion.NotFound;
import app.lab.Model.Host;
import app.lab.Model.Housing;
import app.lab.Repository.HostRepository;
import app.lab.Service.CountryService;
import app.lab.Service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostImpl  implements HostService {
    private final HostRepository hostRepository;

    private final CountryService countryService;
    public HostImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return Optional.of(hostRepository.findById(id).orElseThrow(NotFound::new));
    }

    @Override
    public Optional<Host> create(HostDTO hostDTO) {
        Optional<Country> country =  countryService.findById(hostDTO.getCountryId());
        Host host = new Host(hostDTO.getName(),hostDTO.getSurname(),country.get());
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> edit(Long id, HostDTO hostDTO) {
        Host host = findById(id).get();
        Optional<Country> country =  countryService.findById(hostDTO.getCountryId());
        host.setName(hostDTO.getName());
        host.setSurname(hostDTO.getSurname());
        host.setCountry(country.get());
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> delete(Long hostId) {
        Host host = findById(hostId).get();
        hostRepository.delete(host);
        return Optional.of(host);
    }
}
