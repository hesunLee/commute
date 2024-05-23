package com.project.commute.domain.member;

import com.project.commute.domain.team.TeamMemberList;
import com.project.commute.domain.work.WorkHistory;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name="birthday")
    private LocalDate birthday;

    @Column(nullable = false, name="workStartDate")
    private LocalDate workStartDate;

    @Column(name="workEndDate")
    private LocalDate workEndDate;

    @Column(name="createAt")
    private LocalDateTime createAt;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private TeamMemberList teamMemberLists;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<WorkHistory> workHistories;

    protected Members() { }

    public Members(String name, LocalDate birthday, LocalDate workStartDate, LocalDate workEndDate) {
        this.name = name;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
        this.workEndDate = workEndDate;
    }

    public Members(String name, LocalDate birthday, LocalDate workStartDate) {
        this.name = name;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getWorkStartDate() {
        return workStartDate;
    }

    public LocalDate getWorkEndDate() {
        return workEndDate;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public TeamMemberList getTeamMemberLists() {
        return teamMemberLists;
    }
}
