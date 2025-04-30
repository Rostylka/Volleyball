package com.rostylka.Volleyball.services.implementations;


import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.mappers.PlayerMapper;
import com.rostylka.Volleyball.repositories.PlayerRepository;
import com.rostylka.Volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerResponseDto createPlayer(PlayerRequestDto playerRequestDto) {
        return playerMapper.toPlayerResponseDto(playerRepository.save(playerMapper.toPlayer(playerRequestDto)));

    }

    @Override
    public List<PlayerResponseDto> readAllPlayers() {
        return playerRepository.findAll().stream().map(playerMapper::toPlayerResponseDto).toList();
    }

    @Override
    public PlayerResponseDto findPlayerById(Long id) {
        return playerMapper.toPlayerResponseDto(playerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Player Not Found")));
    }

    @Override
    public PlayerResponseDto updatePlayer(Long id, PlayerRequestDto playerRequestDto) {
        if (playerRepository.existsById(id)) {
            return playerMapper.toPlayerResponseDto(playerRepository.save(playerMapper.toPlayer(playerRequestDto)));
        } else throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Player Not Found");
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
