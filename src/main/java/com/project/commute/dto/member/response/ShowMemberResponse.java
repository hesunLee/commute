package com.project.commute.dto.member.response;

import com.project.commute.domain.member.Members;

import java.time.LocalDate;

public class ShowMemberResponse {
    private long memberId;
    private String name;
    private String teamName;
    private String role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public ShowMemberResponse(long memberId, String name, String teamName, String role, LocalDate birthday, LocalDate workStartDate) {
        this.memberId = memberId;
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public ShowMemberResponse(Members members) {
        this.memberId = members.getId();
        this.name = members.getName();
        this.teamName = members.getTeamMemberLists().getTeam().getName();
        this.role = members.getTeamMemberLists().getMemberRole();
        this.birthday = members.getBirthday();
        this.workStartDate = members.getWorkStartDate();
    }

    public long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }
}
