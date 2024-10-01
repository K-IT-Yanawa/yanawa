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
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    //회원가입 페이지로 이동
    @GetMapping("signup")
    public String goToSignup(MemberDTO memberDTO ,HttpSession session) {
        return "member/signup"; // 회원가입 페이지 뷰
    }

    // 이메일 중복 체크
    @GetMapping("check-email-duplicate")
    @ResponseBody
    public Map<String, Boolean> checkEmailDuplicate(@RequestParam String email) {
        boolean isDuplicate = memberService.isEmailDuplicate(email);
//        memberService 객체를 이용해 이메일 중복 여부를 확인한다
//        이때 isEmailDuplicate(email) 메서드는 전달받은 이메일이 이미 데이터베이스에 존재하는지 확인하고,
//        true (중복됨) 또는 false (중복되지 않음)를 반환한다.
        Map<String, Boolean> response = new HashMap<>();
//        응답 데이터를 저장할 Map 객체를 생성
//        이 맵에 중복 여부를 담아 응답으로 보낼 준비를 한다
        response.put("duplicate", isDuplicate);
//        마지막으로, 중복 여부를 담은 맵을 반환한다.
//        이 데이터는 JSON 형식으로 클라이언트에게 전달됩니다.
        return response;
    }

    // 닉네임 중복 체크
    @GetMapping("check-nickname-duplicate")
    @ResponseBody
    public Map<String, Boolean> checkNickNameDuplicate(@RequestParam String nickname) {
        boolean isDuplicate = memberService.isNickNameDuplicate(nickname);
//        memberService 객체를 이용해 닉네임 중복 여부를 확인한다
//        이때 isNickNameDuplicate(nickname) 메서드는 전달받은 닉네임이 이미 데이터베이스에 존재하는지 확인하고,
//        true (중복됨) 또는 false (중복되지 않음)를 반환한다.
        Map<String, Boolean> response = new HashMap<>();
//        응답 데이터를 저장할 Map 객체를 생성
//        이 맵에 중복 여부를 담아 응답으로 보낼 준비를 한다
        response.put("duplicate", isDuplicate);
//        마지막으로, 중복 여부를 담은 맵을 반환한다.
//        이 데이터는 JSON 형식으로 클라이언트에게 전달됩니다.
        return response;
    }

    // 회원가입완료후 로그인페이지로 이동
    @PostMapping("signup")
    public RedirectView signup(MemberDTO memberDTO) {
        log.info("회원가입 요청 데이터: {}", memberDTO);

        // 데이터베이스에 저장
        memberService.join(memberDTO);
//        회원가입성공시 회원 이름을 출력
        log.info("회원가입 성공 : {}", memberDTO.getMemberName());
//      그후로 로그인 페이지로 Redirect
        return new RedirectView("/member/login");
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
        // 로그인 페이지
        return "member/login";
    }

    //  이메일과 비밀번호로 일반 회원 로그인
    @PostMapping("/login")
    public RedirectView login(@RequestParam String email, @RequestParam String password, String save,
                              RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) {
        log.info("로그인 요청 데이터: email={}, password={}", email, password);

        // 이메일과 비밀번호로 로그인 시도
        Optional<MemberVO> foundMember = memberService.login(email, password);

        // 로그인 실패시 LoginFailException
        MemberVO memberVO = foundMember.orElseThrow(() -> {throw new LoginFailException("(" + LocalTime.now() + ")로그인 실패");});
        session.setAttribute("member", memberVO);

        // isPresent() 객체가 NULL이 아니면 해당객체 사용하여 쿼리실행, NULL 이면 NPE
        // ifPresent() OPtional 객체가 NULL이 아닐때만 람다식 실행, null 체크와 쿼리 실행을 한번에 처리가능
        // ifPresent() 는 리턴값을 갖지 않기때문에 리턴값을 사용해야할때는 ifPresent()사용
        if (foundMember.isPresent()) {
            log.info("로그인 성공! 회원 정보: {}", foundMember.get());

            // 세션에 로그인된 사용자 정보 저장
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

            // 로그인 성공 후 메인 페이지로 리다이렉트
            return new RedirectView("/member/main");
        } else {
            // addFlashAttribute는 일회성으로 한번 사용하면 Redirect후 값이 소멸
            redirectAttributes.addFlashAttribute("loginError", "이메일 또는 비밀번호가 올바르지 않습니다.");

            // 로그인 실패 시 status 값을 false로 전달 (status defalut값은 true)
            return new RedirectView("/member/login?status=false");
        }
    }

//  일반 회원 로그아웃
    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        //세션 완전제거
        session.invalidate();
        log.info("로그아웃 성공 !");
        return new RedirectView("/member/main");
    }

    // 메인 페이지이동
    @GetMapping("main")
    public String goToMainPage() {
        return "main-page/main";
    }

    // 카카오 로그인 확인을 위한 마이페이지
    @GetMapping("my-page")
    public String goToMyPage(MemberDTO memberDTO){
        return "member/my-page";
    }
}
