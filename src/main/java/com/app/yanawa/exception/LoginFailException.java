package com.app.yanawa.exception;

public class LoginFailException extends RuntimeException {

//    일반 로그인 실패시 메세지 출력
    public LoginFailException(String message) {
        super(message);
    }
}