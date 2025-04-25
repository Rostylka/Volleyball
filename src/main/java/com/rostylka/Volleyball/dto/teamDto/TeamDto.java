package com.rostylka.Volleyball.dto.teamDto;

import com.rostylka.Volleyball.dto.playerDto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamDto {

    private Long id;
    private String name;
    private String coach;
    private String city;
    private String logo;
    List<PlayerDto> players;

    @Override
    public String toString() {
        return "TeamDto{" +
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
        TeamDto teamDto = (TeamDto) o;
        return Objects.equals(name, teamDto.name) && Objects.equals(coach, teamDto.coach) && Objects.equals(city, teamDto.city) && Objects.equals(logo, teamDto.logo) && Objects.equals(players, teamDto.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coach, city, logo, players);
    }
}