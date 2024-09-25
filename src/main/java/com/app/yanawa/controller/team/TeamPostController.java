package com.app.yanawa.controller.team;


import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.service.team.TeamPostService;
import com.app.yanawa.service.team.TeamService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/teamRecruitPage/*")
@RequiredArgsConstructor
@Slf4j
public class TeamPostController {
    private final TeamPostService teamPostService;
    private final TeamService teamService;
    private final HttpSession session;

//    @GetMapping("teamrecruitwritePage")
//    public void getTeamPage(@RequestParam(value = "id", required = false) Long id, Model model) {
//        if (id != null) {
//            // TEAM 테이블에서 teamId에 맞는 팀 정보를 가져옴
//            Optional<TeamVO> teamVO = teamPostService.getTeamInformation(id);
//            model.addAttribute("teamVO", teamVO);
//        } else {
//            log.info("실패");
//        }
//    }

//    @PostMapping("teamrecruitwritePage")
//    public RedirectView createTeamPost(@ModelAttribute TeamPostDTO teamPostDTO) {
//        teamPostService.join(teamPostDTO.toVO());
//        return new RedirectView("/teamRecruitPage/teamrecruitDetailPage?id=" + teamPostDTO.getTeamId());
//    }

    @GetMapping("teamrecruitwritePage")
    public void goToWriteForm(Model model){
//        MemberVO memberVO = (MemberVO)session.getAttribute("member");
//        model.addAttribute("team", teamService.getTeam(memberVO.getId()));
        model.addAttribute("team", teamService.getTeam(2L).get());

    }

    @PostMapping("teamrecruitwritePage")
    public void write(TeamPostDTO teamPostDTO){
        teamPostService.join(teamPostDTO.toVO());
    }
}
