package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.PlayerDto;
import com.rostylka.Volleyball.mappers.PlayerMapper;
import com.rostylka.Volleyball.models.Player;
import com.rostylka.Volleyball.repositories.PlayerRepository;
import com.rostylka.Volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {
        return playerMapper.toPlayerDto(playerRepository.save(playerMapper.toPlayer(playerDto)));

    }

    @Override
    public List<PlayerDto> readAllPlayers() {
        return playerRepository.findAll().stream().map(playerMapper::toPlayerDto).toList();
    }

    @Override
    public PlayerDto findPlayerById(Long id) {
        return playerMapper.toPlayerDto(playerRepository.getReferenceById(id));
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) {
        Player updatedPlayer = playerRepository.getReferenceById(playerDto.getId());
        updatedPlayer.setFirstName(playerDto.getFirstName());
        updatedPlayer.setLastName(playerDto.getLastName());
        updatedPlayer.setPosition(playerDto.getPosition());
        updatedPlayer.setAge(playerDto.getAge());
        updatedPlayer.setHeight(playerDto.getHeight());
        updatedPlayer.setWeight(playerDto.getWeight());
        updatedPlayer.setTeamId(playerDto.getTeamId());
        return playerMapper.toPlayerDto(playerRepository.save(updatedPlayer));
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
