package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.team.TeamRequestDto;
import com.rostylka.Volleyball.dto.team.TeamResponseDto;
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
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
        return teamMapper.toTeamResponseDto(teamRepository.save(teamMapper.toTeam(teamRequestDto)));

    }

    @Override
    public List<TeamResponseDto> readAllTeams() {
        return teamRepository.findAll().stream().map(teamMapper::toTeamResponseDto).toList();
    }

    @Override
    public TeamResponseDto findTeamById(Long id) {
        return teamMapper.toTeamResponseDto(teamRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Team Not Found")));
    }

    @Override
    public TeamResponseDto updateTeam(Long id, TeamRequestDto teamRequestDto) {
        if (teamRepository.existsById(id)) {
            return teamMapper.toTeamResponseDto(teamRepository.save(teamMapper.toTeam(teamRequestDto)));
        } else throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Team Not Found");
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}