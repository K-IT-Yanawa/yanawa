package com.app.yanawa.service.team;

import com.app.yanawa.domain.team.TeamDTO;

import java.util.Optional;

public interface TeamService {
    public Optional<TeamDTO> getTeam(Long memberId);
}

