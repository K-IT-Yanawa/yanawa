package com.app.yanawa.service.team;

import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.repository.team.TeamDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamDAO teamDAO;

    @Override
    public Optional<TeamDTO> getTeam(Long memberId) {
        return teamDAO.findByMemberId(memberId);
    }
}
