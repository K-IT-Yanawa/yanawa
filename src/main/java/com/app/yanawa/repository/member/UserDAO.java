package com.app.yanawa.repository.member;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final MemberMapper memberMapper;

    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

    public boolean existsByEmail(String email) {
        return memberMapper.countByEmail(email) > 0; // 0보다 크면 중복
    }
}
