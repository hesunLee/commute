package com.project.commute.domain.work;


import com.project.commute.domain.member.Members;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class WorkHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Members member;

    @Column(name = "workDate")
    private LocalDate workDate;

    @Column(name = "startTime")
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;

    @Column(name = "workingMinutes")
    private long workingMinutes;

    @Column(name = "isHoliday")
    private boolean isHoliday;

    @Column(name = "createAt")
    private LocalDateTime createAt ;

    @Column(name = "updateAt")
    private LocalDateTime updateAt ;

    protected WorkHistory() { }

    public WorkHistory(Members member, LocalDate workDate, LocalTime startTime) {
        this.member = member;
        this.workDate = workDate;
        this.startTime = startTime;
        this.createAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Members getMember() {
        return member;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public long getWorkingMinutes() {
        return workingMinutes;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void updateEndTime(LocalTime endTime) {
        this.endTime = endTime;
        this.workingMinutes = Duration.between(this.startTime, endTime).toMinutes();
        this.updateAt = LocalDateTime.now();
    }
}
