package com.rostylka.Volleyball.services;

import com.rostylka.Volleyball.dto.playerDto.PlayerCreateDto;
import com.rostylka.Volleyball.dto.playerDto.PlayerDto;

import java.util.List;

public interface PlayerService {

    PlayerDto createPlayer(PlayerCreateDto playerCreateDto);

    List<PlayerDto> readAllPlayers();

    PlayerDto findPlayerById(Long id);

    PlayerDto updatePlayer(PlayerDto playerDto);

    void deletePlayer(Long id);
}
