package com.rostylka.Volleyball.services;

import com.rostylka.Volleyball.dto.player.PlayerResponseDto;

public interface TeamPlayerService {

    PlayerResponseDto addPlayerToTeam(Long teamId, Long playerId);

    PlayerResponseDto removePlayerFromTeam(Long teamId, Long playerId);
}
