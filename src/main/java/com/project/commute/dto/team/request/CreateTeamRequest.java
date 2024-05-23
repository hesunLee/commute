package com.project.commute.dto.team.request;

public class CreateTeamRequest {
    private String teamName;

    protected CreateTeamRequest() { }

    public CreateTeamRequest(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }


}
