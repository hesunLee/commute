package com.project.commute.service.work;

import com.project.commute.domain.member.Members;
import com.project.commute.domain.member.MembersRepository;
import com.project.commute.domain.work.WorkHistory;
import com.project.commute.domain.work.WorkHistoryRepository;
import com.project.commute.dto.work.request.CreateWorkHistoryRequest;
import com.project.commute.dto.work.request.UpdateWorkHistoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkService {
    private final WorkHistoryRepository workHistoryRepository;
    private final MembersRepository membersRepository;

    public WorkService(WorkHistoryRepository workHistoryRepository, MembersRepository membersRepository) {
        this.workHistoryRepository = workHistoryRepository;
        this.membersRepository = membersRepository;
    }

    @Transactional
    public void saveWorkHistory(CreateWorkHistoryRequest request) {
        Members member = membersRepository
                .findById(request.getMemberId())
                .orElseThrow(IllegalAccessError::new);

        WorkHistory history = workHistoryRepository
                .findByMemberIdAndWorkDate(request.getMemberId(), request.getWorkDate());
        if (history != null) {
            throw new IllegalArgumentException();
        }

        workHistoryRepository.save(new WorkHistory(member, request.getWorkDate(), request.getStartAt()));
    }


    @Transactional
    public void updateWorkHistory(UpdateWorkHistoryRequest request) {
        WorkHistory history = workHistoryRepository
                .findByMemberIdAndWorkDate(request.getMemberId(), request.getWorkDate());

        if (history == null) {
            throw new IllegalArgumentException();
        }

        history.updateEndTime(request.getEndAt());
    }
}
