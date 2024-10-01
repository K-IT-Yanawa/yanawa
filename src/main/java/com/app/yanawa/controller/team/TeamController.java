package com.app.yanawa.controller.team;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.service.member.MemberService;
import com.app.yanawa.service.team.TeamService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/team/*")
@RequiredArgsConstructor
@Slf4j
public class TeamController {
    private final TeamService teamService;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("team-create")
    public RedirectView goToWriteFrom(TeamDTO teamDTO, Model model) {
        // 세션에서 회원 정보 가져오기
        MemberVO memberVO = (MemberVO) session.getAttribute("member");

        if (memberVO == null) {
            // 로그인되지 않은 상태이면 로그인 페이지로 리다이렉트
            return new RedirectView ("/member/login");
        }

        // 데이터베이스에서 사용자 정보 조회
        Optional<MemberDTO> optionalMemberDTO = memberService.getMember(memberVO.getId());

        if (optionalMemberDTO.isPresent()) {
            // 조회한 사용자 정보를 모델에 추가
            model.addAttribute("member", optionalMemberDTO.get());
        } else {
            // 만약 조회에 실패한 경우 적절한 처리를 할 수 있습니다.
            return new RedirectView ("/error");
        }

        return new RedirectView ("/team/team-create");

    }

    @PostMapping("team-create")
    public RedirectView write(@ModelAttribute TeamDTO teamDTO) {
        log.info("들어옴");
        // 세션에서 멤버 ID를 가져와 teamDTO에 설정
        MemberVO memberVO = (MemberVO) session.getAttribute("member");
        if (memberVO != null) {
            teamDTO.setMemberId(memberVO.getId());
        }

        // 팀 등록 처리
        TeamVO foundTeam = teamService.join(teamDTO.toVO());

        // 팀 정보를 세션에 저장
        session.setAttribute("team", foundTeam);

        log.info("팀 정보: {}", foundTeam);
        log.info(teamDTO.toString());
        return new RedirectView("/member/main");
    }

}
