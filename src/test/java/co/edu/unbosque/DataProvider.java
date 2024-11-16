package co.edu.unbosque;

import co.edu.unbosque.dtos.PlayerDTO;
import co.edu.unbosque.persistence.entites.Player;

import java.util.List;
import java.util.Optional;

public class DataProvider {

    public static List<Player> playerListMock(){
        System.out.println("Getting PLayer List Mock");
        return List.of(
                new Player(1L, "Lionel Messi", "Inter Miami", "Delantero"),
                new Player(2L, "Cristiano Ronaldo", "Al Nassr", "Delantero"),
                new Player(3L, "Neymar Jr", "Paris Saint-Germain", "Delantero"),
                new Player(4L, "Kylian Mbappé", "Paris Saint-Germain", "Delantero"),
                new Player(5L, "Kevin De Bruyne", "Manchester City", "Voltante"),
                new Player(6L, "Virgil Van Dijk", "Liverpool", "Defensa")
        );
    }

    public static Optional<Player> playerMock(){
        return Optional.of(new Player(1L, "Lionel Messi", "Inter Miami", "Delantero"));
    }

    public static PlayerDTO newPlayerMock(){
        return new PlayerDTO(7L, "Luis Diaz", "Delantero", "Liverpool");
    }

}
