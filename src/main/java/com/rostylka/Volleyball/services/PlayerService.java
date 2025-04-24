package com.rostylka.Volleyball.services;

import com.rostylka.Volleyball.dto.PlayerDto;

import java.util.List;

public interface PlayerService {

    PlayerDto createPlayer(PlayerDto playerDto);

    List<PlayerDto> readAllPlayers();

    PlayerDto findPlayerById(Long id);

    PlayerDto updatePlayer(PlayerDto playerDto);

    void deletePlayer(Long id);
}
