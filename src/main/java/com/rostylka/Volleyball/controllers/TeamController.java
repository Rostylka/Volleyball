package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.dto.team.TeamRequestDto;
import com.rostylka.Volleyball.dto.team.TeamResponseDto;
import com.rostylka.Volleyball.services.TeamPlayerService;
import com.rostylka.Volleyball.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/teams")
public class TeamController {

    private final TeamService teamService;
    private final TeamPlayerService teamPlayerService;

    @GetMapping
    public List<TeamResponseDto> getAllTeams() {
        return teamService.readAllTeams();
    }

    @GetMapping("/{id}")
    public TeamResponseDto getTeamById(@PathVariable Long id) {
        return teamService.findTeamById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamResponseDto createTeam(@RequestBody TeamRequestDto teamRequestDto) {
        return teamService.createTeam(teamRequestDto);
    }

    @PutMapping("/{id}")
    public TeamResponseDto updateTeam(@PathVariable Long id, @RequestBody TeamRequestDto teamRequestDto) {
        return teamService.updateTeam(id, teamRequestDto);
    }

    @PatchMapping("/{id}/add-player/{playerId}")
    public PlayerResponseDto addPlayerToTeam(@PathVariable Long id,
                                             @PathVariable Long playerId) {
        return teamPlayerService.addPlayerToTeam(id, playerId);
    }

    @PatchMapping("/{id}/remove-player/{playerId}")
    public PlayerResponseDto removePlayerFromTeam(@PathVariable Long id,
                                                  @PathVariable Long playerId) {
        return teamPlayerService.removePlayerFromTeam(id, playerId);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

}
