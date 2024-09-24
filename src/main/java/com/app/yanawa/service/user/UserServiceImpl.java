package com.app.yanawa.service.user;

import com.app.yanawa.domain.user.UserVO;
import com.app.yanawa.repository.user.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Override
    public void join(UserVO userVO) {
        userDAO.save(userVO);
    }
}
