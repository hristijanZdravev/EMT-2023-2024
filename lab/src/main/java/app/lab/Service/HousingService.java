package app.lab.Service;

import app.lab.Model.DTO.HousingDTO;
import app.lab.Model.Housing;

import java.util.List;
import java.util.Optional;

public interface HousingService {
    List<Housing> findAll();
    Optional<Housing> findById(Long id);
Optional<Housing> create(HousingDTO housingDTO);

Optional<Housing> edit(Long id,HousingDTO housingDTO);
Optional<Housing> delete(Long housingId);

Optional<Housing> bookmark(Long housingId);

Optional<Housing> rent(Long housingId);


}
