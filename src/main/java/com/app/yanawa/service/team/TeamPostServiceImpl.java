package com.app.yanawa.service.team;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.repository.team.TeamDAO;
import com.app.yanawa.repository.team.TeamPostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class TeamPostServiceImpl implements TeamPostService {
    private final TeamPostDAO teamPostDAO;
    private final TeamDAO teamDAO;

    @Override
    public Optional<MemberVO> getMemberInformaion(Long id) {
        return teamPostDAO.findMemberById(id);
    }

    @Override
    public Optional<TeamVO> getTeamInformation(Long id) {
        return teamPostDAO.findById(id);
    }

    @Override
    public void join(TeamPostVO teamPostVO) {
        teamPostDAO.save(teamPostVO);
    }
}
