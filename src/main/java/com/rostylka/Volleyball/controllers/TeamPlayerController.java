package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.services.TeamPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/team_players")
public class TeamPlayerController {
    private final TeamPlayerService teamPlayerService;

    @PatchMapping("/add_team_player")
    public ResponseEntity<PlayerResponseDto> addPlayerToTeam(@RequestParam Long player,
                                                            @RequestParam Long team){
        return ResponseEntity.ok().body(teamPlayerService.addPlayerToTeam(team, player));
    }

    @PatchMapping("/remove_from_team")
    public ResponseEntity<PlayerResponseDto> removePlayerFromTeam(@RequestParam Long player){
        return ResponseEntity.ok().body(teamPlayerService.removePlayerFromTeam(player));
    }
}
