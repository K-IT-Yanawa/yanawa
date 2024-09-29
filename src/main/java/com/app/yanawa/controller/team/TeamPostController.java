package com.app.yanawa.controller.team;


import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamPostPagination;
import com.app.yanawa.domain.team.TeamVO;
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
@RequestMapping("/yanawa/teamPost")
@RequiredArgsConstructor
@Slf4j
public class TeamPostController {
    private final TeamPostService teamPostService;
    private final TeamService teamService;
    private final HttpSession session;

    @GetMapping("teamRecruitWrite")
    public String goToWriteForm(TeamPostDTO teamPostDTO, Model model){
        TeamVO teamVO = (TeamVO)session.getAttribute("team");
        model.addAttribute("team", teamService.getTeam(teamVO.getId()));
//        model.addAttribute("team", teamService.getTeam(5L).get());
        return "teamRecruit/teamRecruitWrite";
    }

    @PostMapping("teamRecruitWrite")
    public RedirectView write(TeamPostDTO teamPostDTO){
//        teamPostDTO.setTeamId(((MemberVO) session.getAttribute("team")).getId());
        teamPostService.write(teamPostDTO.toVO());
        // 팀모집 목록 페이지로 이동하기(작업 필요)
        log.info("{}", teamPostDTO);
        log.info(teamPostDTO.toString());
        return new RedirectView("/teamRecruit/teamRecruitList");
    }

    @GetMapping("teamRecruitList")
    public void getList(TeamPostPagination teamPostPagination, Model model){
        teamPostPagination.setTotal(teamPostPagination.getTotal());
        teamPostPagination.progress();
        model.addAttribute("teamPosts", teamPostService.getList(teamPostPagination));
    }

}
