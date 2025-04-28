package com.rostylka.Volleyball.mappers;

import com.rostylka.Volleyball.dto.TeamDto;
import com.rostylka.Volleyball.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public interface TeamMapper {

    @Mapping(target = "id", ignore = true)
    Team toTeam(TeamDto teamDto);

    //@Mapping(target = "id", ignore = true)
    TeamDto toTeamDto(Team team);

}
