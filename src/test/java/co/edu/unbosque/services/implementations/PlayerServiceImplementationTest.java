package co.edu.unbosque.services.implementations;

import co.edu.unbosque.DataProvider;
import co.edu.unbosque.dtos.PlayerDTO;
import co.edu.unbosque.persistence.entites.Player;
import co.edu.unbosque.persistence.repositories.implementations.PlayerRepositoryImplementation;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplementationTest {

    @Mock
    private PlayerRepositoryImplementation repository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PlayerServiceImplementation service;


    @Test
    public void testFindAll(){
        //Given - Class attributes.
        //When
        when(repository.findAll()).thenReturn(DataProvider.playerListMock());
        when(modelMapper.map(any(), eq(PlayerDTO.class))).thenAnswer(invocation -> {
            Player player = invocation.getArgument(0);
            return new PlayerDTO(player.getId(), player.getName(), player.getTeam(), player.getPosition());
        });

        List<PlayerDTO> result = service.findAll();
        //Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(6, result.size());

        assertEquals("Lionel Messi", result.get(0).getName());
        assertEquals("Inter Miami", result.get(0).getTeam());
        assertEquals("Delantero", result.get(0).getPosition());
        assertInstanceOf(PlayerDTO.class, result.get(0));

        verify(repository, times(1)).findAll();
        verify(modelMapper, times(6)).map(any(), eq(PlayerDTO.class));
    }

    @Test
    public void testFindById(){
        //Given -- Attributes and parameters
        Long id = 1L;
        //When
        when
                (this.repository.findById(anyLong()))
                .thenReturn(DataProvider.playerMock());
        when
                (modelMapper.map(any(), eq(PlayerDTO.class)))
                .thenAnswer(
                        invocation -> {
                        Player player = invocation.getArgument(0);
                        return new PlayerDTO(player.getId(), player.getName(), player.getTeam(), player.getPosition());
                        });

        Optional<PlayerDTO> playerDTO = this.service.findById(id);
        //Then

        assertTrue(playerDTO.isPresent());
        assertEquals("Lionel Messi", playerDTO.get().getName());
        assertEquals("Inter Miami", playerDTO.get().getTeam());
        assertEquals("Delantero", playerDTO.get().getPosition());
        assertInstanceOf(PlayerDTO.class, playerDTO.get());


        verify(repository, times(1)).findById(anyLong());
        verify(modelMapper, times(1)).map(any(), eq(PlayerDTO.class));

    }

    @Test
    public void testSave(){
        //Given
        PlayerDTO playerDTO = DataProvider.newPlayerMock();
        //When
        when
                (modelMapper.map(any(), eq(Player.class)))
                .thenAnswer(
                        invocation -> {
                            PlayerDTO dto = invocation.getArgument(0);
                            return new Player(dto.getId(), dto.getName(), dto.getTeam(), dto.getPosition());
                        });
        service.save(playerDTO);
        //Then
        ArgumentCaptor<Player> playerCaptor = ArgumentCaptor.forClass(Player.class);
        verify(repository).save(any(Player.class));
        verify(repository).save(playerCaptor.capture());
        verify(modelMapper, times(1)).map(any(), eq(Player.class));

        assertEquals(7l, playerCaptor.getValue().getId());
        assertEquals("Luis Diaz", playerCaptor.getValue().getName());

    }

    @Test
    public void testDelete(){
        //Given
        Long id = 1L;
        //When
        service.deleteById(id);
        //Then
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        verify(repository).deleteById(anyLong());
        verify(repository).deleteById(captor.capture());
        assertEquals(1L, captor.getValue());
    }


}
