package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.playerDto.PlayerCreateDto;
import com.rostylka.Volleyball.dto.playerDto.PlayerDto;
import com.rostylka.Volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayer() {
        return ResponseEntity.ok().body(playerService.readAllPlayers());
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(playerService.findPlayerById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<PlayerDto> updatePlayer(@RequestBody PlayerDto playerDto) {
        return ResponseEntity.ok().body(playerService.updatePlayer(playerDto));
    }

    @PostMapping("/create")
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerCreateDto playerCreateDto) {
        return ResponseEntity.ok().body(playerService.createPlayer(playerCreateDto)); //todo change ok
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
    }
}
