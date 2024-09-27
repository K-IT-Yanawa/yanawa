package com.app.yanawa.mapper.team;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface TeamMapper {
    public void insert(TeamVO teamVO);

    public Optional<TeamDTO> selectByMemberId(Long memberId);
}