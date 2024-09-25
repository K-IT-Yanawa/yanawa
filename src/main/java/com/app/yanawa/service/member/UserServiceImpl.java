package com.app.yanawa.service.member;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.repository.member.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements MemberService {
    private final UserDAO userDAO;

    @Override
    public void join(MemberVO memberVO) {
        userDAO.save(memberVO);
    }

    @Override
    public boolean isEmailDuplicate(String email) {
        return userDAO.existsByEmail(email);
    }
}
