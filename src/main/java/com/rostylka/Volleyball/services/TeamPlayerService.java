package com.rostylka.Volleyball.services;

import com.rostylka.Volleyball.dto.playerDto.PlayerDto;

public interface TeamPlayerService {

    PlayerDto addPlayerToTeam(Long teamId, Long playerId);

    PlayerDto removePlayerFromTeam(Long player);
}
