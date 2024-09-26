package com.app.yanawa.controller.member;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.service.member.MemberService;
import com.app.yanawa.service.member.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/yanawa/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberServiceImpl memberServiceImpl;

    // 이메일 중복 체크
    @GetMapping("check-email-duplicate")
    @ResponseBody
    public Map<String, Boolean> checkEmailDuplicate(@RequestParam String email) {
        boolean isDuplicate = memberService.isEmailDuplicate(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("duplicate", isDuplicate);
        return response;
    }

    // 닉네임 중복 체크
    @GetMapping("check-nickname-duplicate")
    @ResponseBody
    public Map<String, Boolean> checkNickNameDuplicate(@RequestParam String nickname) {
        boolean isDuplicate = memberService.isNickNameDuplicate(nickname);
        Map<String, Boolean> response = new HashMap<>();
        response.put("duplicate", isDuplicate);
        return response;
    }

    // 로그인 요청 처리
    @PostMapping("login")
    public String goToLoginPage(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        log.info("로그인 요청 데이터: email={}, password={}", email, password);

        // 이메일과 비밀번호로 로그인 시도
        Optional<MemberVO> foundMember = memberService.selectByMemberEmailAndMemberPassword(email, password);

        if (foundMember.isPresent()) {
            log.info("로그인 성공! 회원 정보: {}", foundMember.get());
            // 로그인 성공 후 홈 페이지로 리다이렉트
            return "redirect:/yanawa/home"; // 홈 페이지 경로로 수정
        } else {
            log.info("로그인 실패! 잘못된 이메일 또는 비밀번호.");
            redirectAttributes.addFlashAttribute("errorMessage", "잘못된 이메일 또는 비밀번호입니다.");
            return "redirect:/yanawa/member/login"; // 로그인 페이지로 리다이렉트
        }
    }

}
