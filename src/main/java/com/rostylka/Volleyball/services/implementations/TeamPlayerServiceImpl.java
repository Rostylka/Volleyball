package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.mappers.PlayerMapper;
import com.rostylka.Volleyball.services.PlayerService;
import com.rostylka.Volleyball.services.TeamPlayerService;
import com.rostylka.Volleyball.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class TeamPlayerServiceImpl implements TeamPlayerService {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final PlayerMapper playerMapper;

    @Override
    public PlayerResponseDto addPlayerToTeam(Long teamId, Long playerId) {
        try {
            teamService.findTeamById(teamId);
            PlayerResponseDto playerResponseDto = playerService.findPlayerById(playerId);
            playerResponseDto.setTeamId(teamId);
            return playerService.updatePlayer(playerId, playerMapper.toPlayerRequestDto(playerResponseDto));
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Bed Request");
        }
    }

    @Override
    public PlayerResponseDto removePlayerFromTeam(Long playerId) {
        PlayerResponseDto playerResponseDto = playerService.findPlayerById(playerId);
        playerResponseDto.setTeamId(null);
        return playerService.updatePlayer(playerId, playerMapper.toPlayerRequestDto(playerResponseDto));
    }
}
