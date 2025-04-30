package com.rostylka.Volleyball.services;

import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import com.rostylka.Volleyball.dto.player.PlayerResponseDto;

import java.util.List;

public interface PlayerService {

    PlayerResponseDto createPlayer(PlayerRequestDto playerRequestDto);

    List<PlayerResponseDto> readAllPlayers();

    PlayerResponseDto findPlayerById(Long id);

    PlayerResponseDto updatePlayer(Long id, PlayerRequestDto playerRequestDto);

    void deletePlayer(Long id);
}
