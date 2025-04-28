package com.rostylka.Volleyball.dto;

import com.rostylka.Volleyball.models.Position;
import lombok.*;

import java.util.Objects;

@Data
public class PlayerDto {

    private String firstName;
    private String lastName;
    private Position position;
    private int age;
    private String height;
    private String weight;
    private Long teamId;

}
