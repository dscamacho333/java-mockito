package co.edu.unbosque;

import co.edu.unbosque.dtos.PlayerDTO;
import co.edu.unbosque.persistence.entites.Player;
import co.edu.unbosque.persistence.repositories.implementations.PlayerRepositoryImplementation;
import co.edu.unbosque.persistence.repositories.interfaces.IPlayerRepository;
import co.edu.unbosque.services.implementations.PlayerServiceImplementation;
import co.edu.unbosque.services.interfaces.IPlayerService;
import org.modelmapper.ModelMapper;


public class Main {
    public static void main(String[] args) {
        /*
        IPlayerRepository repository = new PlayerRepositoryImplementation();
        ModelMapper modelMapper = new ModelMapper();
        IPlayerService service = new PlayerServiceImplementation(repository, modelMapper);

        service.save(new PlayerDTO(7L, "Luis Diaz", "Delantero", "Liverpool"));
        System.out.println(service.findAll());
        System.out.println(service.findAll());
        System.out.println(service.findById(1L).get());
        service.deleteById(1L);
        System.out.println(service.findAll());*/

    }
}