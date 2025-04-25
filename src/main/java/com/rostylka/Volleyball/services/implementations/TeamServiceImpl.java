package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.teamDto.TeamCreateDto;
import com.rostylka.Volleyball.dto.teamDto.TeamDto;
import com.rostylka.Volleyball.mappers.TeamMapper;
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
    public TeamDto createTeam(TeamCreateDto teamCreateDto) {
        return teamMapper.toTeamDto(teamRepository.save(teamMapper.toTeam(teamCreateDto)));

    }

    @Override
    public List<TeamDto> readAllTeams() {
        return teamRepository.findAll().stream().map(teamMapper::toTeamDto).toList();
    }

    @Override
    public TeamDto findTeamById(Long id) {
        return teamMapper.toTeamDto(teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Team Not Found")));
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto) {
        return teamMapper.toTeamDto(teamRepository.save(teamMapper.toTeam(teamDto)));
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}