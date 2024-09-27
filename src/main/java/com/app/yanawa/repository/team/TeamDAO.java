package com.app.yanawa.repository.team;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.mapper.team.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamDAO {
    private final TeamMapper teamMapper;

    public void save(TeamVO teamVO) { teamMapper.insert(teamVO); }

    public Optional<TeamDTO> findByMemberId(Long id) {
        return teamMapper.selectById(id);
    }
}
