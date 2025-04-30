package com.rostylka.Volleyball.dto.team;

import lombok.Data;

@Data
public class TeamRequestDto {

    private String name;
    private String coach;
    private String city;
    private String logo;
}