package com.app.yanawa.mapper.team;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;


@Mapper
public interface TeamPostMapper {
    public void insert(TeamPostVO teamPostVO);
}

