package com.app.yanawa.repository.team;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.mapper.team.TeamPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamPostDAO {
    private final TeamPostMapper teamPostMapper;

    public void save(TeamPostVO teamPostVO) {

        teamPostMapper.insert(teamPostVO);
    }
}

