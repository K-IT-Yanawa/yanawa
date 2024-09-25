package com.app.yanawa.controller.member;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/yanawa/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    // 이메일 중복 체크
    @GetMapping("check-email-duplicate")
    @ResponseBody
    public Map<String, Boolean> checkEmailDuplicate(@RequestParam String email) {
        boolean isDuplicate = memberService.isEmailDuplicate(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("duplicate", isDuplicate);
        return response;
    }

    // 회원가입 페이지로 이동
    @GetMapping("signup")
    public String goToSignup(MemberDTO memberDTO) {
        return "login_page/signup";
    }

    // 회원가입 완료페이지로 이동
    @PostMapping("signup")
    public RedirectView signup(MemberDTO memberDTO) {
        memberService.join(memberDTO.toVO());
        log.info("회원가입 성공: {}", memberDTO.getMemberEmail());
        return new RedirectView("/yanawa/login");
    }
}
