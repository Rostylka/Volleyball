package com.rostylka.Volleyball.controllers;

import com.rostylka.Volleyball.dto.playerDto.PlayerCreateDto;
import com.rostylka.Volleyball.dto.playerDto.PlayerDto;
import com.rostylka.Volleyball.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(playerService.findPlayerById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerCreateDto playerCreateDto){
        return ResponseEntity.ok().body(playerService.createPlayer(playerCreateDto));
    }
}
