package com.app.yanawa.repository.user;

import com.app.yanawa.domain.user.UserVO;
import com.app.yanawa.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

//    회원가입
    public void save(UserVO userVO) {
        userMapper.insert(userVO);
    }
}
