package com.project.commute.service.team;

import com.project.commute.domain.team.Teams;
import com.project.commute.domain.team.TeamsRepository;
import com.project.commute.dto.team.request.CreateTeamRequest;
import com.project.commute.dto.team.response.ShowTeamResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamsRepository teamsRepository;

    public TeamService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @Transactional
    public void saveTeam(CreateTeamRequest request) {
        Teams team = teamsRepository.findByName(request.getTeamName());
        if (team != null) {
            throw new IllegalArgumentException();
        }

        teamsRepository.save(new Teams(request.getTeamName()));
    }

    @Transactional(readOnly = true)
    public List<ShowTeamResponse> getTeam() {
        List<ShowTeamResponse> teams = teamsRepository.findAll()
                .stream()
                .map( t -> new ShowTeamResponse(t))
                .collect(Collectors.toList());

        return teams;
    }
}
