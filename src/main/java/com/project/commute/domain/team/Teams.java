package com.project.commute.domain.team;

import com.project.commute.domain.member.Members;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name="memberCount")
    private long memberCount;

    @Column(name="createAt")
    private LocalDateTime createAt;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TeamMemberList> teamMemberLists = new ArrayList<>();

    protected Teams() { }

    public Teams(String name, long memberCount, LocalDateTime createAt) {
        this.name = name;
        this.memberCount = memberCount;
        this.createAt = createAt;
    }

    public Teams(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getMemberCount() {
        return memberCount;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public TeamMemberList getManager() {
        TeamMemberList teams = this.teamMemberLists.stream()
                .filter( team -> team.getMemberRole().equals("MANAGER") )
                .findFirst()
                .orElse(null);

        return teams == null ? null : teams;
    }

    public String getManagerName() {
        TeamMemberList teams = this.teamMemberLists.stream()
                .filter( team -> team.getMemberRole().equals("MANAGER") )
                .findFirst()
                .orElse(null);

        return teams == null ? null : teams.getMember().getName();
    }

    public void updateMemberCount() {
        this.memberCount = this.teamMemberLists.size();
    }

}
