package com.app.yanawa.repository.member;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.mapper.member.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

    public void save(MemberVO memberVO) {
        userMapper.insert(memberVO);
    }

    public boolean existsByEmail(String email) {
        return userMapper.countByEmail(email) > 0; // 0보다 크면 중복
    }
}
