package co.edu.unbosque.persistence.repositories.implementations;

import co.edu.unbosque.persistence.entites.Player;
import co.edu.unbosque.persistence.repositories.interfaces.IPlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerRepositoryImplementation implements IPlayerRepository {

    private List<Player> playerDatabase = new ArrayList<>();


    @Override
    public void save(Player player) {
        System.out.println("Real save() method");
        this.playerDatabase.add(player);
    }

    @Override
    public Optional<Player> findById(Long id) {
        System.out.println("Real findAById() method");
        return Optional.ofNullable(
               this.playerDatabase
                       .stream()
                       .filter((player) -> player.getId() == id)
                       .findFirst()
                       .orElse(null)
        );
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Real deleteById() method");
        this.playerDatabase = this.playerDatabase
                .stream()
                .filter((player) -> player.getId() != id)
                .toList();

    }

    @Override
    public List<Player> findAll() {
        System.out.println("Real findAll() method");
        return this.playerDatabase;
    }
}
