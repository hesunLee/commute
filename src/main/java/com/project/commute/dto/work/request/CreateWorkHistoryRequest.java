package com.project.commute.dto.work.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateWorkHistoryRequest {
    private long memberId;
    private LocalDate workDate;
    private LocalTime startAt;

    public CreateWorkHistoryRequest(long memberId, LocalDate workDate, LocalTime startAt) {
        this.memberId = memberId;
        this.workDate = workDate;
        this.startAt = startAt;
    }

    public long getMemberId() {
        return memberId;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public LocalTime getStartAt() {
        return startAt;
    }
}
