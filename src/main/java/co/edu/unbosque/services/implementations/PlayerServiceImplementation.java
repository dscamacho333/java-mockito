package co.edu.unbosque.services.implementations;

import co.edu.unbosque.dtos.PlayerDTO;
import co.edu.unbosque.persistence.entites.Player;
import co.edu.unbosque.persistence.repositories.interfaces.IPlayerRepository;
import co.edu.unbosque.services.interfaces.IPlayerService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

public class PlayerServiceImplementation implements IPlayerService {


    private final IPlayerRepository repository;
    private final ModelMapper modelMapper;

    public PlayerServiceImplementation(IPlayerRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(PlayerDTO playerDTO) {
        repository.save(
                modelMapper.map(playerDTO, Player.class)
        );
    }

    @Override
    public Optional<PlayerDTO> findById(Long id) {
        var player = repository
                .findById(id)
                .orElseThrow();
        return Optional.ofNullable(
                modelMapper
                        .map(
                                player,
                                PlayerDTO.class
                        )
        );
    }

    @Override
    public void deleteById(Long id) {
        repository
                .deleteById(id);
    }

    @Override
    public List<PlayerDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .toList();
    }
}
