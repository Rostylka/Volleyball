package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.mappers.PlayerMapper;
import com.rostylka.Volleyball.models.Player;
import com.rostylka.Volleyball.repositories.PlayerRepository;
import com.rostylka.Volleyball.repositories.TeamRepository;
import com.rostylka.Volleyball.services.TeamPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@AllArgsConstructor
public class TeamPlayerServiceImpl implements TeamPlayerService {
    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Override
    public PlayerResponseDto addPlayerToTeam(Long teamId, Long playerId) {
        teamRepository.findById(teamId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Team Not Found"));
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Player Not Found"));
        player.setTeamId(teamId);
        player = playerRepository.save(player);
        return playerMapper.toPlayerResponseDto(player);
    }

    @Override
    public PlayerResponseDto removePlayerFromTeam(Long teamId, Long playerId) {
        teamRepository.findById(teamId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Team Not Found"));
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Player Not Found"));
        player.setTeamId(null);
        player = playerRepository.save(player);
        return playerMapper.toPlayerResponseDto(player);
    }
}
