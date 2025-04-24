package com.rostylka.Volleyball.services.implementations;

import com.rostylka.Volleyball.dto.TeamDto;
import com.rostylka.Volleyball.mappers.PlayerMapper;
import com.rostylka.Volleyball.mappers.TeamMapper;
import com.rostylka.Volleyball.models.Team;
import com.rostylka.Volleyball.repositories.TeamRepository;
import com.rostylka.Volleyball.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;
    private final PlayerMapper playerMapper;

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        return teamMapper.toTeamDto(teamRepository.save(teamMapper.toTeam(teamDto)));

    }

    @Override
    public List<TeamDto> readAllTeams() {
        return teamRepository.findAll().stream().map(teamMapper::toTeamDto).toList();
    }

    @Override
    public TeamDto findTeamById(Long id) {
        return teamMapper.toTeamDto(teamRepository.getReferenceById(id));
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto) {
        Team updatedTeam = teamRepository.getReferenceById(teamDto.getId());
        updatedTeam.setName(teamDto.getName());
        updatedTeam.setCoach(teamDto.getCoach());
        updatedTeam.setCity(teamDto.getCity());
        updatedTeam.setLogo(teamDto.getLogo());
        updatedTeam.setPlayers(teamDto.getPlayers().stream().map(playerMapper::toPlayer).toList());
        return teamMapper.toTeamDto(teamRepository.save(updatedTeam));
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}