package app.lab.Service;

import app.lab.Model.DTO.HostDTO;
import app.lab.Model.Host;
import app.lab.Repository.HostRepository;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);

    Optional<Host> create(HostDTO hostDTO);

    Optional<Host> edit(Long id,HostDTO hostDTO);
    Optional<Host> delete(Long hostId);
}
