package co.edu.unbosque.services.interfaces;

import co.edu.unbosque.dtos.PlayerDTO;

import java.util.List;
import java.util.Optional;

public interface IPlayerService {

    void save(PlayerDTO playerDTO);
    Optional<PlayerDTO> findById(Long id);
    void deleteById(Long id);
    List<PlayerDTO> findAll();

}
