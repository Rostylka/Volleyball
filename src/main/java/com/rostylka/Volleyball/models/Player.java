package com.rostylka.Volleyball.models;

import com.rostylka.Volleyball.utils.PositionConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "position")
    @Convert(converter = PositionConverter.class)
    private Position position;
    @Column(name = "age")
    private int age;
    @Column(name = "height")
    private int height;
    @Column(name = "weight")
    private int weight;
    @Column(name = "team_id")
    private Long teamId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age && height == player.height && weight == player.weight && Objects.equals(firstName, player.firstName) && Objects.equals(lastName, player.lastName) && position == player.position && Objects.equals(teamId, player.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, position, age, height, weight, teamId);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
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
