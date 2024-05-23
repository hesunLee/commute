package com.project.commute.dto.member.request;

import java.time.LocalDate;

public class CreateMemberRequest {

    private String name;
    private long teamId;
    private boolean isManager;
    private LocalDate workStartAt;
    private LocalDate birthday;

    public CreateMemberRequest(String name, long teamId, boolean isManager, LocalDate workStartAt, LocalDate birthday) {
        this.name = name;
        this.teamId = teamId;
        this.isManager = isManager;
        this.workStartAt = workStartAt;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public long getTeamId() {
        return teamId;
    }

    public boolean isManager() {
        return isManager;
    }

    public LocalDate getWorkStartAt() {
        return workStartAt;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
