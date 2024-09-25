package com.app.yanawa.mapper.team;

import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;


@Mapper
public interface TeamPostMapper {
    public Optional<MemberVO> selectMemberById(Long id);

    public Optional<TeamVO> selectTeamById(Long id);

    public void insert(TeamPostVO teamPostVO);
}

