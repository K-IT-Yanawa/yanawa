package com.app.yanawa.exception;

public class KakaoLoginFailException extends RuntimeException {
    public KakaoLoginFailException(String message) {
        super(message);
    }
}