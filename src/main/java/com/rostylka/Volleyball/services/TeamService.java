package com.rostylka.Volleyball.services;

import com.rostylka.Volleyball.dto.teamDto.TeamCreateDto;
import com.rostylka.Volleyball.dto.teamDto.TeamDto;

import java.util.List;

public interface TeamService {

    TeamDto createTeam(TeamCreateDto teamCreateDto);

    List<TeamDto> readAllTeams();

    TeamDto findTeamById(Long id);

    TeamDto updateTeam(TeamDto teamDto);

    void deleteTeam(Long id);
}
