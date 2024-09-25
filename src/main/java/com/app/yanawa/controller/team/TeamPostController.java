package com.app.yanawa.controller.team;


import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.domain.member.MemberDTO;
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

    @PostMapping("validatemember")
    public RedirectView validatememberAndRedirect(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        Optional<MemberVO> memberVO = teamPostService.getMemberInformaion(memberDTO.getId());

        if(memberVO.isPresent() &&
                memberVO.get().getMemberName().equals(memberDTO.getMemberName()) &&
                memberVO.get().getMemberEmail().equals(memberDTO.getMemberEmail()) &&
                memberVO.get().getMemberPhone().equals(memberDTO.getMemberPhone())) {
            session.setAttribute("validatedmember", memberVO.get());
            return new RedirectView("/teamRecruitPage/teamrecruitwritePage");
        } else {
            return new RedirectView("/error");
        }

    }

    @GetMapping("register")
    public String teamRecruitWritePage(@RequestParam(value = "teamId", required = false) Long teamId, Model model, HttpSession session) {
        MemberVO validateMemberVO = (MemberVO) session.getAttribute("validatedMember");

        if(teamId != null) {
            Optional<TeamVO> teamVO = teamPostService.getTeamInformation(teamId);
            teamVO.ifPresent(team -> {
                model.addAttribute("teamName", team.getTeamName());
                model.addAttribute("sportsKindRadioId", team.getSportsKindRadioId());
                model.addAttribute("cityName", team.getCityName());
                model.addAttribute("localCityName", team.getLocalCityName());
                model.addAttribute("detailedArea", team.getDetailedArea());
                model.addAttribute("teamActivityTime", team.getTeamActivityTime());
                model.addAttribute("ageRange", team.getAgeRange());
            });
        } else {
            log.error("teamId is null");
        }

        if(validateMemberVO != null) {
            model.addAttribute("memberName", validateMemberVO.getMemberName());
            model.addAttribute("memberEmail", validateMemberVO.getMemberEmail());
            model.addAttribute("memberPhone", validateMemberVO.getMemberPhone());
        }
        return "teamrecruitwritePage";
    }

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
