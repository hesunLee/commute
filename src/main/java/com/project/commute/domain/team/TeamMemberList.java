package com.project.commute.domain.team;

import com.project.commute.domain.member.Members;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class TeamMemberList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Teams team;

    @ManyToOne
    private Members member;

    @Column(nullable = false, name = "memberRole")
    private String memberRole;

    @Column(name = "createAt")
    private LocalDateTime createAt;

    protected TeamMemberList() { }

    public TeamMemberList(Teams team, Members member, boolean isManager) {
        this.team = team;
        this.member = member;
        this.memberRole = isManager ? "MANAGER" : "MEMBER";
        this.createAt = LocalDateTime.now();
    }


    public TeamMemberList(Teams team, Members member, String memberRole, LocalDateTime createAt) {
        this.team = team;
        this.member = member;
        this.memberRole = memberRole;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public Teams getTeam() {
        return team;
    }

    public Members getMember() {
        return member;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void updateRole(String memberRole) {
        this.memberRole = memberRole;
    }
}
