package com.app.yanawa.controller.matching;

import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.service.matching.MatchingService;
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
@RequestMapping("/matchPage/")
@RequiredArgsConstructor
@Slf4j
public class MatchingController {
    private final MatchingService matchingService;
    private final TeamService teamService;
    private final HttpSession session;

    @GetMapping("register")
    public void goToWriteForm(Model model) {
//        MemberVO memberVO = (MemberVO)session.getAttribute("member");
//        model.addAttribute("team", teamService.getTeam(memberVO.getId()));

//        model.addAttribute("matching", teamService.getTeam(1L).get());
//        model.addAttribute("matching", matchingService.getMember(1L).get());

//        Optional<MatchingDTO> matchingDTO = matchingService.getMatchingInfoByMemberId(1L); // 예시로 1L 사용
//        model.addAttribute("matching", matchingDTO);
        // 예시로 1L을 사용, 실제로는 세션이나 로그인된 사용자 정보에서 가져옵니다.
        Long memberId = 1L;

        // 해당 멤버가 소속된 팀 정보 가져오기
        Optional<TeamDTO> teamDTO = teamService.getTeam(memberId);

        // 가져온 팀 정보를 모델에 추가
        if (teamDTO.isPresent()) {
            model.addAttribute("team", teamDTO.get());
        }

        // 매칭 등록을 위한 정보도 모델에 추가
        model.addAttribute("matching", matchingService.getMember(memberId).get());


    }
    @PostMapping("register")
    public RedirectView write(MatchingDTO matchingDTO) {
        log.info(matchingDTO.toString());
        matchingService.write(matchingDTO);
        return new RedirectView("matchMain");
    }
}
