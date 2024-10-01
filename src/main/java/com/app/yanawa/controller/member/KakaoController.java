package com.app.yanawa.controller.member;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.exception.KakaoLoginFailException;
import com.app.yanawa.service.member.KakaoService;
import com.app.yanawa.service.member.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;
    private final MemberService memberService;

    @GetMapping("/kakao/login")
    public RedirectView login(String code, HttpSession session){
        String token = kakaoService.getKakaoAccessToken(code);
        Optional<MemberDTO> kakaoInfo = kakaoService.getKakaoInfo(token);

        // null 이 아니면 로그인
        if(kakaoInfo.isPresent()){
            memberService.join(kakaoInfo.get().toVO());
        }

        session.setAttribute("member", memberService.getKakaoMember(kakaoInfo.get().getMemberKakaoEmail()).get());
        // Kakao 로그아웃을 위해 토큰 저장
        session.setAttribute("kakaoToken", token);

        log.info("카카오 로그인 성공 !");
        return new RedirectView("/member/my-page");
    }

    @GetMapping("/kakao/logout")
    public RedirectView logout(HttpSession session) {
        String kakaoToken = (String) session.getAttribute("kakaoToken");

        if (kakaoToken != null) {
            // Kakao 로그아웃 처리
            boolean logoutSuccess = kakaoService.kakaoLogout(kakaoToken);

            // 로그아웃 처리 결과에 따라 로그 출력
            if (logoutSuccess) {
                log.info("카카오 로그아웃 성공 ! ");
            } else {
                log.info("카카오 로그아웃 실패 ! ");
            }

            // 세션 무효화
            session.invalidate();
        } else {
            // 카카오 로그인이 실패했을 경우의 예외 처리
            throw new KakaoLoginFailException("로그아웃 실패: 카카오 로그인 정보가 없습니다.");
        }

        // 로그아웃 후 메인 페이지로 이동
        return new RedirectView("/member/main");
    }
}














