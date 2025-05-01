package com.rostylka.Volleyball.services.implementations;


import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.exceptions.player.PlayerNotFoundException;
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
    public PlayerResponseDto createPlayer(PlayerRequestDto playerRequestDto) {
        Player newPlayer = playerMapper.toPlayer(playerRequestDto);
        return playerMapper.toPlayerResponseDto(playerRepository.save(newPlayer));

    }

    @Override
    public List<PlayerResponseDto> readAllPlayers() {
        List<Player> allPlayers = playerRepository.findAll();
        return allPlayers.stream().map(playerMapper::toPlayerResponseDto).toList();
    }

    @Override
    public PlayerResponseDto findPlayerById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(PlayerNotFoundException::new);
        return playerMapper.toPlayerResponseDto(player);
    }

    @Override
    public PlayerResponseDto updatePlayer(Long id, PlayerRequestDto playerRequestDto) {
        playerRepository.findById(id)
                .orElseThrow(PlayerNotFoundException::new);
        Player updatedPlayer = playerMapper.toPlayer(playerRequestDto);
        updatedPlayer.setId(id);
        updatedPlayer = playerRepository.save(updatedPlayer);
        return playerMapper.toPlayerResponseDto(updatedPlayer);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
