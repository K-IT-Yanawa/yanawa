package com.app.yanawa.service.member;

import com.app.yanawa.domain.member.UserVO;

public interface MemberService {
    public void join(UserVO user);

    boolean isEmailDuplicate(String email);
}
