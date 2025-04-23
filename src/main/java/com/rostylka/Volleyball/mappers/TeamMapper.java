package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.TeamDto;
import com.rostylka.Volleyball.models.Team;
import org.mapstruct.Mapper;

@Mapper
public interface TeamMapper {

    Team toTeam(TeamDto teamDto);
    TeamDto toTeamDto(Team team);
}
