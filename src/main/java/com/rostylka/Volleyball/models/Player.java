package com.rostylka.Volleyball.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Position position;
    @Column(name = "age")
    private int age;
    @Column(name = "height")
    private int height;
    @Column(name = "weight")
    private int weight;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
