package com.rostylka.Volleyball.dto.team;

import com.rostylka.Volleyball.dto.player.PlayerResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class TeamResponseDto {

    private Long id;
    private String name;
    private String coach;
    private String city;
    private String logo;
    private List<PlayerResponseDto> players;
}