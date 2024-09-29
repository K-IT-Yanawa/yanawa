package com.app.yanawa.service.member;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;

import java.util.Optional;

public interface MemberService {
    //    회원가입
    public void join(MemberDTO memberDTO);

    //    이메일 중복
    public boolean isEmailDuplicate(String email);

    //    닉네임중복
    public boolean isNickNameDuplicate(String nickname);

    //    로그인
    Optional<MemberVO> login(String email, String password);

//
    public Optional<MemberDTO> getMember(Long Id);
}
