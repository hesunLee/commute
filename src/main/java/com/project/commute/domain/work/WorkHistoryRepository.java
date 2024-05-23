package com.project.commute.domain.work;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {

    WorkHistory findByMemberIdAndWorkDate(long memberId, LocalDate workDate);
}
