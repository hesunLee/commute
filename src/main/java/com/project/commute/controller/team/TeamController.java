package com.project.commute.controller.team;


import com.project.commute.dto.team.request.CreateTeamRequest;
import com.project.commute.dto.team.response.ShowTeamResponse;
import com.project.commute.service.team.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team")
    public void saveTeam(@RequestBody CreateTeamRequest request) {
        teamService.saveTeam(request);
    }

    @GetMapping("/team")
    public List<ShowTeamResponse> getTeam() {
        return teamService.getTeam();
    }
}
