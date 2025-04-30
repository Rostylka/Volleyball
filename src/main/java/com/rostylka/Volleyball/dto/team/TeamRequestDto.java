package com.rostylka.Volleyball.dto.team;

import com.rostylka.Volleyball.dto.player.PlayerRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class TeamRequestDto {

    private String name;
    private String coach;
    private String city;
    private String logo;
    private List<PlayerRequestDto> players;
}