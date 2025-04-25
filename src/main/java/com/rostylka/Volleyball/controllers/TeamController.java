package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.playerDto.PlayerCreateDto;
import com.rostylka.Volleyball.dto.playerDto.PlayerDto;
import com.rostylka.Volleyball.dto.teamDto.TeamCreateDto;
import com.rostylka.Volleyball.dto.teamDto.TeamDto;
import com.rostylka.Volleyball.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/teams")
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/{id}")
    public TeamDto getTeamById(@PathVariable("id") Long id) {
        return teamService.findTeamById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<TeamDto> createPlayer(@RequestBody TeamCreateDto teamCreateDto){
        return ResponseEntity.ok().body(teamService.createTeam(teamCreateDto));
    }

}
