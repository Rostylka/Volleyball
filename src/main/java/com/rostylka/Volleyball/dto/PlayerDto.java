package com.rostylka.Volleyball.dto;

import com.rostylka.Volleyball.models.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PlayerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Position position;
    private int age;
    private int height;
    private int weight;
    private TeamDto team;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDto playerDto = (PlayerDto) o;
        return age == playerDto.age && height == playerDto.height && weight == playerDto.weight && Objects.equals(firstName, playerDto.firstName) && Objects.equals(lastName, playerDto.lastName) && position == playerDto.position && Objects.equals(team, playerDto.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, position, age, height, weight, team);
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", team=" + team +
                '}';
    }
}
