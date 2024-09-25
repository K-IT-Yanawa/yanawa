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

    // 회원가입 페이지로 이동
    @GetMapping("signup")
    public String goToSignup(MemberDTO memberDTO) {
        return "login_page/signup"; // 회원가입 페이지 뷰
    }

    // 회원가입완료후 로그인페이지로 이동
    @PostMapping("signup")
    public RedirectView signup(MemberDTO memberDTO) {
        log.info("회원가입 요청 데이터: {}", memberDTO);

        // 데이터베이스에 저장
        memberService.join(memberDTO.toVO());
        log.info("회원가입 성공 : {}", memberDTO.getMemberName());

        return new RedirectView("/yanawa/member/login");
    }

    //    로그인페이지로 이동
    @GetMapping("login")
    public String loginPage() {
        return "login_page/login"; // 로그인 페이지 뷰
    }

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
}
