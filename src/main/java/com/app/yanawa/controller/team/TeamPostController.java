package com.app.yanawa.controller.team;


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

    @PostMapping("validateUser")
    public RedirectView validateUserAndRedirect(@ModelAttribute UserDTO userDTO, HttpSession session) {
        Optional<UserVO> userVO = teamPostService.getUserInformaion(userDTO.getId());

        if(userVO.isPresent() &&
                userVO.get().getUserName().equals(userDTO.getUserName()) &&
                userVO.get().getUserEmail().equals(userDTO.getUserEmail()) &&
                userVO.get().getUserPhone().equals(userDTO.getUserPhone())) {
            session.setAttribute("validatedUser", userVO.get());
            return new RedirectView("/teamRecruitPage/teamrecruitwritePage");
        } else {
            return new RedirectView("/error");
        }

    }

    @GetMapping("register")
    public String teamRecruitWritePage(@RequestParam(value = "teamId", required = false) Long teamId, Model model, HttpSession session) {
        UserVO validateUserVO = (UserVO) session.getAttribute("validatedUser");

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

        if(validateUserVO != null) {
            model.addAttribute("userName", validateUserVO.getUserName());
            model.addAttribute("userEmail", validateUserVO.getUserEmail());
            model.addAttribute("userPhone", validateUserVO.getUserPhone());
        }
        return "teamrecruitwritePage";
    }

    @GetMapping("teamrecruitwritePage")
    public void getTeamPage(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id != null) {
            // TEAM 테이블에서 teamId에 맞는 팀 정보를 가져옴
            Optional<TeamVO> teamVO = teamPostService.getTeamInformation(id);
            model.addAttribute("teamVO", teamVO);
        } else {
            log.info("실패");
        }
    }

    @PostMapping("teamrecruitwritePage")
    public RedirectView createTeamPost(@ModelAttribute TeamPostDTO teamPostDTO) {
        teamPostService.join(teamPostDTO.toVO());
        return new RedirectView("/teamRecruitPage/teamrecruitDetailPage" + teamPostDTO.getTeamId());
    }
}
