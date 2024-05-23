package com.project.commute.service.member;

import com.project.commute.domain.member.Members;
import com.project.commute.domain.member.MembersRepository;
import com.project.commute.domain.team.TeamMemberList;
import com.project.commute.domain.team.TeamMemberListRepository;
import com.project.commute.domain.team.Teams;
import com.project.commute.domain.team.TeamsRepository;
import com.project.commute.dto.member.request.CreateMemberRequest;
import com.project.commute.dto.member.response.ShowMemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MembersRepository membersRepository;
    private final TeamMemberListRepository teamMemberListRepository;
    private final TeamsRepository teamsRepository;

    public MemberService(
            MembersRepository membersRepository,
            TeamMemberListRepository teamMemberListRepository,
            TeamsRepository teamsRepository
        ) {
        this.membersRepository = membersRepository;
        this.teamMemberListRepository = teamMemberListRepository;
        this.teamsRepository = teamsRepository;
    }


    @Transactional
    public void saveMember(CreateMemberRequest request) {
        Members members = new Members(request.getName(), request.getBirthday(), request.getWorkStartAt());
        membersRepository.save(members);

        Teams team = teamsRepository.findById(request.getTeamId()).orElseThrow(IllegalArgumentException::new);

        if (request.isManager()) {
            TeamMemberList teamMember = team.getManager();
            if (teamMember != null) {
                teamMember.updateRole("MEMBER");
            }
        }

        teamMemberListRepository.save(new TeamMemberList(team, members, request.isManager()));
        team.updateMemberCount();
    }

    @Transactional(readOnly = true)
    public List<ShowMemberResponse> getMember() {
        return membersRepository.findAll().stream()
                .map(m -> new ShowMemberResponse(m))
                .collect(Collectors.toList());
    }
}
