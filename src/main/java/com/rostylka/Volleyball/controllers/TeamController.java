package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.TeamDto;
import com.rostylka.Volleyball.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        return ResponseEntity.ok().body(teamService.readAllTeams());
    }

    @GetMapping("/{id}")
    public TeamDto getTeamById(@PathVariable Long id) {
        return teamService.findTeamById(id);
    }

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        return ResponseEntity.ok().body(teamService.createTeam(teamDto)); //todo change ok
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @RequestBody TeamDto teamDto) {
        return ResponseEntity.ok().body(teamService.updateTeam(id, teamDto));
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

}
