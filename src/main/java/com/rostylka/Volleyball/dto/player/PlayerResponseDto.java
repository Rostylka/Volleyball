package com.rostylka.Volleyball.dto.player;

import com.rostylka.Volleyball.models.Position;
import lombok.Data;

@Data
public class PlayerResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Position position;
    private int age;
    private String height;
    private String weight;
    private Long teamId;

}
