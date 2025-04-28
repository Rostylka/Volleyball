package com.rostylka.Volleyball.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    @SequenceGenerator(name = "team_seq", sequenceName = "team_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String coach;
    private String city;
    private String logo;
    @OneToMany(mappedBy = "teamId")
    List<Player> players;

}
