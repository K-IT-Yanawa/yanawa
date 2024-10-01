package com.app.yanawa.service.team;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.domain.team.TeamVO;

import java.util.Optional;

public interface TeamService {
    public TeamVO join(TeamVO teamVO);

    public Optional<TeamDTO> getTeam(Long id);
}

