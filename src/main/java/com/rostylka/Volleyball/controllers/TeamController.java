package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.team.TeamRequestDto;
import com.rostylka.Volleyball.dto.team.TeamResponseDto;
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
    public ResponseEntity<List<TeamResponseDto>> getAllTeams() {
        return ResponseEntity.ok().body(teamService.readAllTeams());
    }

    @GetMapping("/{id}")
    public TeamResponseDto getTeamById(@PathVariable Long id) {
        return teamService.findTeamById(id);
    }

    @PostMapping
    public ResponseEntity<TeamResponseDto> createTeam(@RequestBody TeamRequestDto teamRequestDto) {
        return ResponseEntity.ok().body(teamService.createTeam(teamRequestDto)); //todo change ok
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDto> updateTeam(@PathVariable Long id, @RequestBody TeamRequestDto teamRequestDto) {
        return ResponseEntity.ok().body(teamService.updateTeam(id, teamRequestDto));
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

}
