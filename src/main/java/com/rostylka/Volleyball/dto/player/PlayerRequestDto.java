package com.rostylka.Volleyball.dto.player;

import com.rostylka.Volleyball.models.Position;
import lombok.*;

@Data
public class PlayerRequestDto {

    private String firstName;
    private String lastName;
    private Position position;
    private int age;
    private String height;
    private String weight;
    private Long teamId;

}
