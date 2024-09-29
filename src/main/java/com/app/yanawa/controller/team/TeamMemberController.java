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
    private final TeamService teamService;

    @GetMapping("teamRecruitDetail")
    public void goToWriteFrom(Model model) {
        // 회원 정보
        model.addAttribute("member", memberService.getMember(81L).get());
        // 신청하는 팀 id
        model.addAttribute("team", teamService.getTeam(1L).get());
        log.info("GetMapping 들어옴");
    }

    @PostMapping("teamRecruitDetail")
    public RedirectView write(TeamMemberDTO teamMemberDTO) {
        log.info("PostMapping 1 들어옴");

        teamMemberService.join(teamMemberDTO.toVO());
        log.info("PostMapping 2 들어옴");
        log.info("{}", teamMemberDTO);
        log.info(teamMemberDTO.toString());
        return new RedirectView("/teamRecruit/teamRecruitDetail");
    }
}
