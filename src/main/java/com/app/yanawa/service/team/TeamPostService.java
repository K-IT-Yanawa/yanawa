package com.app.yanawa.service.team;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;

import java.util.Optional;

public interface TeamPostService {
    public Optional<MemberVO> getMemberInformaion(Long id);

    public Optional<TeamVO> getTeamInformation(Long id);

    public void join(TeamPostVO teamPostVO);
}
