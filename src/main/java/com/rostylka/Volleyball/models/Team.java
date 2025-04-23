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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;
    @Column(name = "team_name")
    private String name;
    @Column(name = "coach")
    private String coach;
    @Column(name = "city")
    private String city;
    @Column(name = "logo")
    private String logo;
    @OneToMany(mappedBy = "team")
    List<Player> players;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coach='" + coach + '\'' +
                ", city='" + city + '\'' +
                ", logo='" + logo + '\'' +
                ", players=" + players +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) && Objects.equals(coach, team.coach) && Objects.equals(city, team.city) && Objects.equals(logo, team.logo) && Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coach, city, logo, players);
    }
}
