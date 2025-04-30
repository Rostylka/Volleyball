package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerResponseDto>> getAllPlayer() {
        return ResponseEntity.ok().body(playerService.readAllPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> getPlayerById(@PathVariable Long id) {
        return ResponseEntity.ok().body(playerService.findPlayerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerResponseDto> updatePlayer(@PathVariable Long id, @RequestBody PlayerRequestDto playerRequestDto) {
        return ResponseEntity.ok().body(playerService.updatePlayer(id, playerRequestDto));
    }

    @PostMapping
    public ResponseEntity<PlayerResponseDto> createPlayer(@RequestBody PlayerRequestDto playerRequestDto) {
        return ResponseEntity.ok().body(playerService.createPlayer(playerRequestDto)); //todo change ok
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
    }
}
