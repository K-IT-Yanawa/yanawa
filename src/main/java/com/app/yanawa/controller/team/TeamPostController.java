package com.app.yanawa.controller.team;


import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.service.team.TeamPostService;
import com.app.yanawa.service.team.TeamService;
import jakarta.servlet.http.HttpSession;
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
public class TeamPostController {
    private final TeamPostService teamPostService;
    private final TeamService teamService;
//    private final HttpSession session;

    @GetMapping("team-recruit-write")
    public void goToWriteForm(Model model, HttpSession session) {
//        MemberVO memberVO = (MemberVO)session.getAttribute("member");
//        model.addAttribute("team", teamService.getTeam(memberVO.getId()));
        model.addAttribute("team", teamService.getTeam(8L).get());
    }

    @PostMapping("team-recruit-write")
    public RedirectView write(TeamPostDTO teamPostDTO) {
        teamPostService.write(teamPostDTO.toVO());
        // 팀모집 목록 페이지로 이동하기(작업 필요)
        log.info("{}", teamPostDTO);
        log.info(teamPostDTO.toString());
        return new RedirectView("/team/team-recruit-list");
    }
}