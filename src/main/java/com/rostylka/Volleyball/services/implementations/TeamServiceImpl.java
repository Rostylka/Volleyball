package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.team.TeamRequestDto;
import com.rostylka.Volleyball.dto.team.TeamResponseDto;
import com.rostylka.Volleyball.mappers.TeamMapper;
import com.rostylka.Volleyball.models.Player;
import com.rostylka.Volleyball.models.Team;
import com.rostylka.Volleyball.repositories.TeamRepository;
import com.rostylka.Volleyball.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;

    @Override
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
        Team team = teamMapper.toTeam(teamRequestDto);
        return teamMapper.toTeamResponseDto(teamRepository.save(team));

    }

    @Override
    public List<TeamResponseDto> readAllTeams() {
        List<Team> allTeams = teamRepository.findAll();
        return allTeams.stream().map(teamMapper::toTeamResponseDto).toList();
    }

    @Override
    public TeamResponseDto findTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Team Not Found"));
        return teamMapper.toTeamResponseDto(team);
    }

    @Override
    public TeamResponseDto updateTeam(Long id, TeamRequestDto teamRequestDto) {
        Team oldteam = teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Team Not Found"));
        Team updatedTeam = teamMapper.toTeam(teamRequestDto);
        List<Player> players = oldteam.getPlayers();
        updatedTeam.setId(id);
        updatedTeam.setPlayers(players);
        updatedTeam = teamRepository.save(updatedTeam);
        return teamMapper.toTeamResponseDto(updatedTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}