package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.playerDto.PlayerCreateDto;
import com.rostylka.Volleyball.dto.playerDto.PlayerDto;
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
    public PlayerDto createPlayer(PlayerCreateDto playerCreateDto) {
        return playerMapper.toPlayerDto(playerRepository.save(playerMapper.toPlayer(playerCreateDto)));

    }

    @Override
    public List<PlayerDto> readAllPlayers() {
        return playerRepository.findAll().stream().map(playerMapper::toPlayerDto).toList();
    }

    @Override
    public PlayerDto findPlayerById(Long id) {
        return playerMapper.toPlayerDto(playerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Player Not Found")));
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) {
        if (playerRepository.existsById(playerDto.getId())) {
            return playerMapper.toPlayerDto(playerRepository.save(playerMapper.toPlayer(playerDto)));
        } else throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Player Not Found");
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
