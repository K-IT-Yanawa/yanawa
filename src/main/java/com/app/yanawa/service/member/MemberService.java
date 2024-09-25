package com.app.yanawa.service.member;

import com.app.yanawa.domain.member.MemberVO;

public interface MemberService {
    public void join(MemberVO user);

    boolean isEmailDuplicate(String email);
}
