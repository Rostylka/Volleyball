package com.rostylka.Volleyball.services;

import com.rostylka.Volleyball.dto.team.TeamRequestDto;
import com.rostylka.Volleyball.dto.team.TeamResponseDto;

import java.util.List;

public interface TeamService {

    TeamResponseDto createTeam(TeamRequestDto teamRequestDto);

    List<TeamResponseDto> readAllTeams();

    TeamResponseDto findTeamById(Long id);

    TeamResponseDto updateTeam(Long id, TeamRequestDto teamRequestDto);

    void deleteTeam(Long id);
}
