package com.app.yanawa.controller.team;


import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.*;
import com.app.yanawa.service.member.MemberService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/yanawa/team")
@RequiredArgsConstructor
@Slf4j
public class TeamPostController {
    private final TeamPostService teamPostService;
    private final TeamService teamService;
    private final MemberService memberService;
    private final HttpSession session;

    @GetMapping("teamRecruitWrite")
    public String goToWriteForm(@RequestParam("teamId") Long id, TeamPostDTO teamPostDTO, Model model){
        log.info("goToWriteForm 들어옴");

        // 세션에서 회원 정보 가져오기
        MemberVO memberVO = (MemberVO) session.getAttribute("member");

        // 데이터베이스에서 팀 정보 조회
        Optional<TeamDTO> optionalTeamDTO = teamService.getTeam(id);
        Optional<MemberDTO> optionalMemberDTO = memberService.getMember(memberVO.getId());

        // 로그 출력
        log.info("팀 정보: {}", optionalTeamDTO + "들어옴");
        log.info("회원 정보: {}", optionalMemberDTO + "들어옴");

        if (optionalTeamDTO.isPresent() && optionalMemberDTO.isPresent()) {
            // 조회한 팀 정보를 모델에 추가
            model.addAttribute("team", optionalTeamDTO.get());
            model.addAttribute("member", optionalMemberDTO.get());
        } else {
            // 만약 조회에 실패한 경우 적절한 처리를 할 수 있습니다.
            return "redirect:/error";
        }

//        // 세션에서 팀 정보 가져오기
//        TeamVO teamVO = (TeamVO) session.getAttribute("team");
//        // 세션에서 회원 정보 가져오기
//        MemberVO memberVO = (MemberVO) session.getAttribute("member");
//
//        log.info("{}", teamVO + "들어옴1");
//        log.info("{}", memberVO + "들어옴2");
//
//        if (teamVO == null) {
//            // 만약 세션에 팀 정보가 없다면 팀 등록 페이지로 리다이렉트
//            return "redirect:/yanawa/team/teamCreate";
//        }
//
//        log.info("들어옴2 ~");
//        log.info("들어옴2 ~~");
//
//        // 데이터베이스에서 팀 정보 조회
//        Optional<TeamDTO> optionalTeamDTO = teamService.getTeam(teamVO.getId());
//        // 데이터베이스에서 사용자 정보 조회
//        Optional<MemberDTO> optionalMemberDTO = memberService.getMember(memberVO.getId());
//
//        log.info("{}", optionalTeamDTO + "들어옴3");
//        log.info("{}", optionalMemberDTO + "들어옴4");
//
//        if (optionalTeamDTO.isPresent()) {
//            // 조회한 팀 정보를 모델에 추가
//            model.addAttribute("team", teamVO.getId());
//            model.addAttribute("member", optionalMemberDTO.get());
//            log.info("{}", optionalTeamDTO.isPresent() + "들어옴5");
//        } else {
//            // 만약 조회에 실패한 경우 적절한 처리를 할 수 있습니다.
//            return "redirect:/error";
//        }



        return "teamRecruit/teamRecruitWrite";
    }

    @PostMapping("teamRecruitWrite")
    public RedirectView write(TeamPostDTO teamPostDTO){
        log.info("RedirectView 들어옴");

        // 세션에서 팀 ID를 가져와 teamDTO에 설정
        TeamVO teamVO = (TeamVO) session.getAttribute("team");

        log.info("{}", teamVO + "Post 들어옴1");

        if (teamVO != null) {
            teamPostDTO.setTeamId(teamVO.getId());
            log.info("{}", teamPostDTO + "Post 들어옴2");
        }
        // 팀 모집 글 등록 처리
        TeamPostVO foundTeamPost = teamPostService.write(teamPostDTO.toVO());

        log.info("{}", foundTeamPost + "Post 들어옴3");

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
