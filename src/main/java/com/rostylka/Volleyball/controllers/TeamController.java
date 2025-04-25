package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.teamDto.TeamCreateDto;
import com.rostylka.Volleyball.dto.teamDto.TeamDto;
import com.rostylka.Volleyball.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/teams")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        return ResponseEntity.ok().body(teamService.readAllTeams());
    }

    @GetMapping("/{id}")
    public TeamDto getTeamById(@PathVariable("id") Long id) {
        return teamService.findTeamById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamCreateDto teamCreateDto) {
        return ResponseEntity.ok().body(teamService.createTeam(teamCreateDto));
    }

    @PutMapping("/update")
    public ResponseEntity<TeamDto> updateTeam(@RequestBody TeamDto teamDto) {
        return ResponseEntity.ok().body(teamService.updateTeam(teamDto));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeam(id);
    }

}
