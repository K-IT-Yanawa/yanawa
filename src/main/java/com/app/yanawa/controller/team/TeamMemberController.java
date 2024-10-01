package com.app.yanawa.controller.team;

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
@RequestMapping("/team/*")
@RequiredArgsConstructor
@Slf4j
public class TeamMemberController {
    private final TeamMemberService teamMemberService;
    private final MemberService memberService;
    private final TeamService teamService;

    @GetMapping("recruit-detail")
    public void  goToWriteFrom(Model model) {
        // 회원 정보
        model.addAttribute("member", memberService.getMember(3L).get());
        // 신청하는 팀 id
        model.addAttribute("team", teamService.getTeam(8L).get());
    }

    @PostMapping("recruit-detail")
    public RedirectView write(TeamMemberDTO teamMemberDTO) {

        teamMemberService.join(teamMemberDTO.toVO());
        log.info("{}", teamMemberDTO);
        log.info(teamMemberDTO.toString());
        return new RedirectView("/team/recruit-detail");
    }
}
