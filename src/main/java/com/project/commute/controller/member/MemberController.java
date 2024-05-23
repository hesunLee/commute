package com.project.commute.controller.member;


import com.project.commute.dto.member.request.CreateMemberRequest;
import com.project.commute.dto.member.response.ShowMemberResponse;
import com.project.commute.service.member.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/member")
    public void saveMember(@RequestBody CreateMemberRequest request) {
        memberService.saveMember(request);
    }

    @GetMapping("/member")
    public List<ShowMemberResponse> getMember() {
        return memberService.getMember();
    }


}
