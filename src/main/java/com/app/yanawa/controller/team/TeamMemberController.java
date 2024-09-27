package com.app.yanawa.controller.team;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.domain.team.TeamMemberDTO;
import com.app.yanawa.service.member.MemberService;
import com.app.yanawa.service.team.TeamMemberService;
import com.app.yanawa.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/teamRecruit/*")
@RequiredArgsConstructor
@Slf4j
public class TeamMemberController {
    private final TeamMemberService teamMemberService;
    private final MemberService memberService;

    @GetMapping("teamRecruitDetail")
    public void goToWriteFrom(Model model) {
        model.addAttribute("member", memberService.getMember(7L).get());
    }

    @PostMapping("teamRecruitDetail")
    public RedirectView write(TeamMemberDTO teamMemberDTO) {
        teamMemberService.join(teamMemberDTO.toVO());
        return new RedirectView("/teamRecruit/teamCreate");
    }
}
