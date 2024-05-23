package com.project.commute.dto.team.response;

import com.project.commute.domain.team.Teams;

public class ShowTeamResponse {

    private long teamId;
    private String name;
    private String manager;
    private long memberCount;

    public ShowTeamResponse(long teamId, String name, String manager, long memberCount) {
        this.teamId = teamId;
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }

    public ShowTeamResponse(Teams teams) {
        this.teamId = teams.getId();
        this.name = teams.getName();
        this.manager = teams.getManagerName();
        this.memberCount = teams.getMemberCount();
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public long getMemberCount() {
        return memberCount;
    }
}
