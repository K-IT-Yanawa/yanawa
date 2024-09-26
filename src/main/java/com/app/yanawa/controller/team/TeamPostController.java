package com.app.yanawa.controller.team;


import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.service.team.TeamPostService;
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
public class TeamPostController {
    private final TeamPostService teamPostService;
    private final TeamService teamService;
//    private final HttpSession session;

    @GetMapping("teamRecruitWrite")
    public void goToWriteForm(Model model){
//        MemberVO memberVO = (MemberVO)session.getAttribute("member");
//        model.addAttribute("team", teamService.getTeam(memberVO.getId()));
        model.addAttribute("team", teamService.getTeam(2L).get());

    }

    @PostMapping("teamRecruitWrite")
    public RedirectView write(TeamPostDTO teamPostDTO){
        teamPostService.join(teamPostDTO.toVO());
        return new RedirectView("/teamRecruit/teamRecruitWrite");
    }
}
