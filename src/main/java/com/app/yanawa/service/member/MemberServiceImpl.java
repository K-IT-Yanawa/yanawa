package com.app.yanawa.service.member;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

    //    이메일 중복
    @Override
    public boolean isEmailDuplicate(String email) {
        return memberDAO.existsByEmail(email);
    }

    //    닉네임 중복
    @Override
    public boolean isNickNameDuplicate(String nickname) {
        return memberDAO.existsByNickName(nickname);
    }

}