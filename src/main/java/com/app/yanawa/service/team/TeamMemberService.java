package com.app.yanawa.service.team;

import com.app.yanawa.domain.team.TeamMemberVO;

public interface TeamMemberService {
    // 팀 신청(지원)
    public void join(TeamMemberVO teamMemberVO);
}
