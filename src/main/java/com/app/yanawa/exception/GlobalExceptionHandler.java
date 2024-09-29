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
        return new RedirectView("/yanawa/member/login?status=false");
    }

//   추가 ExceptionHandler 여기에 적기
}
