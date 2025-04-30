package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.team.TeamRequestDto;
import com.rostylka.Volleyball.dto.team.TeamResponseDto;
import com.rostylka.Volleyball.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public interface TeamMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "players", ignore = true)
    Team toTeam(TeamRequestDto teamRequestDto);

    TeamResponseDto toTeamResponseDto(Team team);

}
