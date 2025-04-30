package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import com.rostylka.Volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<PlayerResponseDto> getAllPlayer() {
        return playerService.readAllPlayers();
    }

    @GetMapping("/{id}")
    public PlayerResponseDto getPlayerById(@PathVariable Long id) {
        return playerService.findPlayerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponseDto createPlayer(@RequestBody PlayerRequestDto playerRequestDto) {
        return playerService.createPlayer(playerRequestDto);
    }

    @PutMapping("/{id}")
    public PlayerResponseDto updatePlayer(@PathVariable Long id, @RequestBody PlayerRequestDto playerRequestDto) {
        return playerService.updatePlayer(id, playerRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
    }
}
