package com.app.yanawa.controller.member;

import com.app.yanawa.exception.LoginFailException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.service.member.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/yanawa/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    // 회원가입 페이지로 이동
    @GetMapping("signup")
    public String goToSignup(MemberDTO memberDTO ,HttpSession session) {
        return "login_page/signup"; // 회원가입 페이지 뷰
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

    // 회원가입완료후 로그인페이지로 이동
    @PostMapping("signup")
    public RedirectView signup(MemberDTO memberDTO) {
        log.info("회원가입 요청 데이터: {}", memberDTO);

        // 데이터베이스에 저장
        memberService.join(memberDTO);
        log.info("회원가입 성공 : {}", memberDTO.getMemberName());

        return new RedirectView("/yanawa/member/login");
    }

    //    로그인페이지로 이동
    @GetMapping("login")
    //    status쓸거면 직접 입력해줘야함
    public String goToLoginPage(@ModelAttribute("status") String status, MemberDTO memberDTO, HttpServletRequest request, Model model) {

        //쿠키 조회
        Cookie[] cookies = request.getCookies();

        for(int i=0; i<cookies.length; i++) {
            log.info(cookies[i].getName());
            // save라는 key가 있다면,
            if(cookies[i].getName().equals("save")) {
                //해당 value를 화면으로 보낸다
                model.addAttribute("save",cookies[i].getValue());
            }
            // 이메일 쿠키 조회
            if(cookies[i].getName().equals("email")) {
                memberDTO.setMemberEmail(cookies[i].getValue());
            }

            // 패스워드 쿠키 조회
            if(cookies[i].getName().equals("password")) {
                memberDTO.setMemberPassword(cookies[i].getValue());
            }
        }
        return "login_page/login"; // 로그인 페이지
    }

    //  이메일과 비밀번호로 로그인
    @PostMapping("/login")
    public RedirectView login(@RequestParam String email, @RequestParam String password, String save, HttpSession session, HttpServletResponse response) {
        log.info("로그인 요청 데이터: email={}, password={}", email, password);

        // 이메일과 비밀번호로 로그인 시도
        Optional<MemberVO> foundMember = memberService.login(email, password);

        MemberVO memberVO = foundMember.orElseThrow(() -> {throw new LoginFailException("(" + LocalTime.now() + ")로그인 실패");});
        session.setAttribute("member", memberVO);

        if (foundMember.isPresent()) {
            log.info("로그인 성공! 회원 정보: {}", foundMember.get());

            // 세션에 로그인된 사용자 정보 저장 (필요하다면)
            session.setAttribute("member", foundMember.get());

            // 로그인 유지버튼이 선택된 경우 쿠키 설정
            if (save != null) {
                // 쿠키 생성 및 저장
                Cookie saveCookie = new Cookie("save", save);
                Cookie emailCookie = new Cookie("email", email);
                Cookie passwordCookie = new Cookie("password", password);

                // -1: 쿠키를 계속 유지
                saveCookie.setMaxAge(-1);
                emailCookie.setMaxAge(-1);
                passwordCookie.setMaxAge(-1);

                // 쿠키응답
                response.addCookie(saveCookie);
                response.addCookie(emailCookie);
                response.addCookie(passwordCookie);

            } else {
                // 로그인 유지 버튼이 선택되지 않은 경우 쿠키 삭제
                Cookie saveCookie = new Cookie("save", null);
                Cookie emailCookie = new Cookie("email", null);
                Cookie passwordCookie = new Cookie("password", null);

                // setMaxAge 를 0으로 하여 초기상태로만듬
                saveCookie.setMaxAge(0);
                emailCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);

                // 쿠키응답
                response.addCookie(saveCookie);
                response.addCookie(emailCookie);
                response.addCookie(passwordCookie);
            }
        }
        // 로그인 성공 후 메인 페이지로 리다이렉트
        return new RedirectView("/yanawa/member/main");
    }


//  로그아웃
    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        log.info("{}","로그아웃 성공 !");
        return new RedirectView("/yanawa/member/login");
    }

    // 메인 페이지이동
    @GetMapping("/main")
    public String goToMainPage() {
        return "mainPage/main";
    }

    // 메인 페이지에서 통합로그인으로 넘어가기
    @GetMapping("/loginHome")
    public String goToLoginHome() {
        return "login_page/loginHome";
    }
}
