package com.rostylka.Volleyball.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamDto {

    private String name;
    private String coach;
    private String city;
    private String logo;
    List<PlayerDto> players;
}