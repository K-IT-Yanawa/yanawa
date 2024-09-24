package com.app.yanawa.service.user;

import com.app.yanawa.domain.user.UserVO;

public interface UserService {
    public void join(UserVO user);

    boolean isEmailDuplicate(String email);
}
