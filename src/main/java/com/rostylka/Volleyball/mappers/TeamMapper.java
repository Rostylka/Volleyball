package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.teamDto.TeamCreateDto;
import com.rostylka.Volleyball.dto.teamDto.TeamDto;
import com.rostylka.Volleyball.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public interface TeamMapper {

    Team toTeam(TeamDto teamDto);

    @Mapping(target = "players", ignore = true)
    @Mapping(target = "id", ignore = true)
    Team toTeam(TeamCreateDto teamCreateDto);

    TeamDto toTeamDto(Team team);

    TeamCreateDto toTeamCreateDto(Team team);

}
