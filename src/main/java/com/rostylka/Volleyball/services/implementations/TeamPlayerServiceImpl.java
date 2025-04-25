package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.playerDto.PlayerDto;
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

    @Override
    public PlayerDto addPlayerToTeam(Long teamId, Long playerId) {
        try {
            teamService.findTeamById(teamId);
            PlayerDto playerDto = playerService.findPlayerById(playerId);
            playerDto.setTeamId(teamId);
            return playerService.updatePlayer(playerDto);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Bed Request");
        }
    }

    @Override
    public PlayerDto removePlayerFromTeam(Long playerId) {
        PlayerDto playerDto = playerService.findPlayerById(playerId);
        playerDto.setTeamId(null);
        return playerService.updatePlayer(playerDto);
    }
}
