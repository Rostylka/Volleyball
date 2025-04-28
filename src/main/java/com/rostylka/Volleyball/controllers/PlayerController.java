package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.PlayerDto;
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
    public ResponseEntity<List<PlayerDto>> getAllPlayer() {
        return ResponseEntity.ok().body(playerService.readAllPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id) {
        return ResponseEntity.ok().body(playerService.findPlayerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id, @RequestBody PlayerDto playerDto) {
        return ResponseEntity.ok().body(playerService.updatePlayer(id, playerDto));
    }

    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        return ResponseEntity.ok().body(playerService.createPlayer(playerDto)); //todo change ok
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
    }
}
