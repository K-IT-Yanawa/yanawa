package com.app.yanawa.mapper.member;

import com.app.yanawa.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insert(MemberVO memberVo);

    int countByEmail(String email);
}
