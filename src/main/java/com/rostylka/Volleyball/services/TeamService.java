package com.rostylka.Volleyball.services;

import com.rostylka.Volleyball.dto.TeamDto;

import java.util.List;

public interface TeamService {

    TeamDto createTeam(TeamDto teamDto);

    List<TeamDto> readAllTeams();

    TeamDto findTeamById(Long id);

    TeamDto updateTeam(Long id, TeamDto teamDto);

    void deleteTeam(Long id);
}
