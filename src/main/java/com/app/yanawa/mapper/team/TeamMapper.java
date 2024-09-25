package com.app.yanawa.mapper.team;

import com.app.yanawa.domain.team.TeamDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface TeamMapper {
    public Optional<TeamDTO> selectByMemberId(Long memberId);
}