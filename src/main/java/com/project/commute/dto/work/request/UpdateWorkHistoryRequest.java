package com.project.commute.dto.work.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateWorkHistoryRequest {
    private long memberId;
    private LocalDate workDate;
    private LocalTime endAt;

    public UpdateWorkHistoryRequest(long memberId, LocalDate workDate, LocalTime endAt) {
        this.memberId = memberId;
        this.workDate = workDate;
        this.endAt = endAt;
    }

    public long getMemberId() {
        return memberId;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public LocalTime getEndAt() {
        return endAt;
    }
}
