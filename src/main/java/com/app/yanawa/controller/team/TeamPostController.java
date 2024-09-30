package com.app.yanawa.controller.team;


import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.*;
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

import java.util.Optional;

@Controller
@RequestMapping("/yanawa/team")
@RequiredArgsConstructor
@Slf4j
public class TeamPostController {
    private final TeamPostService teamPostService;
    private final TeamService teamService;
    private final HttpSession session;

    @GetMapping("teamRecruitWrite")
    public String goToWriteForm(TeamPostDTO teamPostDTO, Model model){
        // 세션에서 팀 정보 가져오기
        TeamVO teamVO = (TeamVO) session.getAttribute("team");

        if (teamVO == null) {
            // 만약 세션에 팀 정보가 없다면 팀 등록 페이지로 리다이렉트
            return "redirect:/yanawa/team/teamCreate";
        }

        // 데이터베이스에서 팀 정보 조회
        Optional<TeamDTO> optionalTeamDTO = teamService.getTeam(teamVO.getId());

        if (optionalTeamDTO.isPresent()) {
            // 조회한 팀 정보를 모델에 추가
            model.addAttribute("team", optionalTeamDTO.get());
        } else {
            // 만약 조회에 실패한 경우 적절한 처리를 할 수 있습니다.
            return "redirect:/error";
        }

        return "teamRecruit/teamRecruitWrite";
    }

    @PostMapping("teamRecruitWrite")
    public RedirectView write(TeamPostDTO teamPostDTO){
        // 세션에서 팀 ID를 가져와 teamDTO에 설정
        TeamVO teamVO = (TeamVO) session.getAttribute("team");
        if (teamVO != null) {
            Optional<TeamDTO> optionalTeamDTO = teamService.getTeam(teamVO.getId());
        }
        // 팀 모집 글 등록 처리
        TeamPostVO foundTeamPost = teamPostService.write(teamPostDTO.toVO());

        // 팀 모집 글 정보를 세션에 저장
        session.setAttribute("teamPost", foundTeamPost);

        // 팀 모집 목록 페이지로 이동하기(작업 필요)
        log.info("{}", teamPostDTO);
        log.info(teamPostDTO.toString());
        return new RedirectView("/yanawa/team/teamRecruitList");
    }

//    @GetMapping("teamRecruitList")
//    public void getList(TeamPostPagination teamPostPagination, Model model){
//        teamPostPagination.setTotal(teamPostPagination.getTotal());
//        teamPostPagination.progress();
//        model.addAttribute("teamPosts", teamPostService.getList(teamPostPagination));
//    }

}
