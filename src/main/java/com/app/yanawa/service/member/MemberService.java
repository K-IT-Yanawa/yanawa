package com.app.yanawa.service.member;

import com.app.yanawa.domain.member.MemberVO;

public interface MemberService {
    //    회원가입
    public void join(MemberVO member);

    //    이메일 중복
    public boolean isEmailDuplicate(String email);

    //    닉네임중복
    public boolean isNickNameDuplicate(String nickname);
}
