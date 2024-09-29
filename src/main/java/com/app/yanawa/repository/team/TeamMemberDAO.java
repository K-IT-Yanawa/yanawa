package com.app.yanawa.repository.team;

import com.app.yanawa.domain.team.TeamMemberVO;
import com.app.yanawa.mapper.team.TeamMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TeamMemberDAO {
    private final TeamMemberMapper teamMemberMapper;

    // 팀 신청(지원)
    public void save(TeamMemberVO teamMemberVO) { teamMemberMapper.insert(teamMemberVO); }

}

