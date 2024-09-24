package com.app.yanawa.mapper.user;

import com.app.yanawa.domain.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(UserVO userVo);

    int countByEmail(String email);
}
