package com.app.yanawa.mapper.team;

import com.app.yanawa.domain.team.TeamMemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMemberMapper {
    // 팀 신청(지원)
    public void insert(TeamMemberVO teamMemberVO);
}
