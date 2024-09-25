package com.app.yanawa.mapper.member;

import com.app.yanawa.domain.member.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(UserVO userVo);

    int countByEmail(String email);
}
