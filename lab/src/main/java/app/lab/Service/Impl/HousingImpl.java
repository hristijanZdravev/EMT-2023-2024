package app.lab.Service.Impl;

import app.lab.Model.DTO.HousingDTO;
import app.lab.Model.Excepetion.BadRequest;
import app.lab.Model.Excepetion.NoAvalibleRooms;
import app.lab.Model.Excepetion.NotFound;
import app.lab.Model.Host;
import app.lab.Model.Housing;
import app.lab.Repository.HousingRepository;
import app.lab.Service.HostService;
import app.lab.Service.HousingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HousingImpl implements HousingService {

    private final HousingRepository housingRepository;
    private final HostService hostService;
    public HousingImpl(HousingRepository housingRepository, HostService hostService) {
        this.housingRepository = housingRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Housing> findAll() {
        return housingRepository.findAll();
    }

    @Override
    public Optional<Housing> findById(Long id) {
        return Optional.of(housingRepository.findById(id).orElseThrow(NotFound::new));
    }

    @Override
    public Optional<Housing> create(HousingDTO housingDTO) {
        Optional<Host> host = hostService.findById(housingDTO.getHostId());
        Housing housing = new Housing(housingDTO.getName(),housingDTO.getCategory(),host.get(),housingDTO.getNumRooms(),false);
        return Optional.of(housingRepository.save(housing));
    }

    @Override
    public Optional<Housing> edit(Long id, HousingDTO housingDTO) {
        Housing housing = findById(id).get();
        Optional<Host> host = hostService.findById(housingDTO.getHostId());
        housing.setName(housingDTO.getName());
        housing.setCategory(housingDTO.getCategory());
        housing.setHost(host.get());
        housing.setNumRooms(housingDTO.getNumRooms());

        return Optional.of(housingRepository.save(housing));
    }

    @Override
    public Optional<Housing> delete(Long housingId) {
        Housing housing = findById(housingId).get();
        housingRepository.delete(housing);
        return Optional.of(housing);
    }

    @Override
    public Optional<Housing> bookmark(Long housingId) {
        Housing housing = findById(housingId).get();
        if (housing.getNumRooms() == 0){
            throw new NoAvalibleRooms();
        }
        housing.setNumRooms(housing.getNumRooms()-1);

        return Optional.of(housingRepository.save(housing));
    }

    @Override
    public Optional<Housing> rent(Long housingId) {
        Housing housing = findById(housingId).get();

        if(!housing.getIsRented()) {
            housing.setIsRented(true);
            return Optional.of(housingRepository.save(housing));
        }

         throw new BadRequest();
    }


}
