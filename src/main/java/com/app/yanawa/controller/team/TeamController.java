package com.app.yanawa.controller.team;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.service.member.MemberService;
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
public class TeamController {
    private final TeamService teamService;
    private final MemberService memberService;

    @GetMapping("teamCreate")
    public void goToWriteFrom(Model model) {
        // 회원 id => (팀장)
        model.addAttribute("member", memberService.getMember(2L).get());
    }

    @PostMapping("teamCreate")
    public RedirectView write(TeamDTO teamDTO) {
        teamService.join(teamDTO.toVO());
        return new RedirectView("/teamRecruit/teamCreate");
    }
}
