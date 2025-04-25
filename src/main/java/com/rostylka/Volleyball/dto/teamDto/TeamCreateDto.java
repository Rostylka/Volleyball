package com.rostylka.Volleyball.dto.teamDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamCreateDto {

    private String name;
    private String coach;
    private String city;
    private String logo;

    @Override
    public String toString() {
        return "TeamDto{" +
                ", name='" + name + '\'' +
                ", coach='" + coach + '\'' +
                ", city='" + city + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamCreateDto teamCreateDto = (TeamCreateDto) o;
        return Objects.equals(name, teamCreateDto.name) && Objects.equals(coach, teamCreateDto.coach)
                && Objects.equals(city, teamCreateDto.city) && Objects.equals(logo, teamCreateDto.logo) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coach, city, logo);
    }
}