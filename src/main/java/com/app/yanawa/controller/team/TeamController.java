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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/yanawa/team")
@RequiredArgsConstructor
@Slf4j
public class TeamController {
    private final TeamService teamService;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("teamCreate")
    public String goToWriteFrom(TeamDTO teamDTO, Model model) {
        // 세션에서 사용자 ID 가져오기
        MemberVO memberVO = (MemberVO) session.getAttribute("member");

        if (memberVO == null) {
            // 로그인되지 않은 상태이면 로그인 페이지로 리다이렉트
            return "redirect:/yanawa/member/login";
        }

        // 데이터베이스에서 사용자 정보 조회
        Optional<MemberDTO> optionalMemberDTO = memberService.getMember(memberVO.getId());

        if (optionalMemberDTO.isPresent()) {
            // 조회한 사용자 정보를 모델에 추가
            model.addAttribute("member", optionalMemberDTO.get());
        } else {
            // 만약 조회에 실패한 경우 적절한 처리를 할 수 있습니다.
            return "redirect:/error";
        }

        return "teamRecruit/teamCreate";

    }

    @PostMapping("teamCreate")
    public RedirectView write(TeamDTO teamDTO) {
        log.info("들어옴");
        // 세션에서 멤버 ID를 가져와 teamDTO에 설정
        MemberVO memberVO = (MemberVO) session.getAttribute("member");
        if (memberVO != null) {
            teamDTO.setMemberId(memberVO.getId());
        }

//        teamDTO.setMemberId(((TeamVO) session.getAttribute("member")).getId());

        teamService.join(teamDTO.toVO());
        log.info("{}", teamDTO);
        log.info(teamDTO.toString());
        return new RedirectView("/yanawa/team/teamRecruitList");
    }
}
