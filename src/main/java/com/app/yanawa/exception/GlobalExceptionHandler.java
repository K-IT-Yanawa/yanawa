package com.app.yanawa.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
//    로그인 실패시 오류
    @ExceptionHandler(LoginFailException.class)
    protected RedirectView handleLoginFailException(LoginFailException e) {
        log.info("로그인 실패! 이메일과 비밀번호를 확인하세요!");
//        로그인 실패시 status=false 를 줘서 로그인 실패를 알림
        return new RedirectView("/member/login?status=false");
    }

    @ExceptionHandler(KakaoLoginFailException.class)
    protected RedirectView handleKaKaoLoginFailException(KakaoLoginFailException e) {
        log.info("카카오톡 로그인 실패! 회원정보가 없습니다.");
        return new RedirectView("/member/login");
    }

    //   추가 ExceptionHandler 여기에 적기
}
