package com.rostylka.Volleyball.dto.playerDto;

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
public class PlayerCreateDto {

    private String firstName;
    private String lastName;
    private Position position;
    private int age;
    private int height;
    private int weight;
    private Long teamId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCreateDto playerCreateDto = (PlayerCreateDto) o;
        return age == playerCreateDto.age && height == playerCreateDto.height && weight == playerCreateDto.weight
                && Objects.equals(firstName, playerCreateDto.firstName)
                && Objects.equals(lastName, playerCreateDto.lastName) && position == playerCreateDto.position
                && Objects.equals(teamId, playerCreateDto.teamId);    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, position, age, height, weight, teamId);
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", teamId=" + teamId +
                '}';
    }
}
