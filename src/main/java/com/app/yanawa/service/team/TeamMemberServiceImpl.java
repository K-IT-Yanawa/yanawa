package com.app.yanawa.service.team;

import com.app.yanawa.domain.team.TeamMemberVO;
import com.app.yanawa.repository.team.TeamMemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class TeamMemberServiceImpl implements TeamMemberService {
    private final TeamMemberDAO teamMemberDAO;

    // 팀 신청(지원)
    @Override
    public void join(TeamMemberVO teamMemberVO) {
        teamMemberDAO.save(teamMemberVO);
    }
}
