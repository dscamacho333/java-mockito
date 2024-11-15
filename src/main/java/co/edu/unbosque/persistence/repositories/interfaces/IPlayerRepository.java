package co.edu.unbosque.persistence.repositories.interfaces;

import co.edu.unbosque.persistence.entites.Player;

import java.util.List;
import java.util.Optional;

public interface IPlayerRepository {

    void save(Player player);
    Optional<Player> findById(Long id);
    void deleteById(Long id);
    List<Player> findAll();


}
