package com.app.yanawa.service.team;

import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamPostPagination;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.repository.team.TeamPostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class TeamPostServiceImpl implements TeamPostService {
    private final TeamPostDAO teamPostDAO;

    @Override
    public void write(TeamPostVO teamPostVO) {
        teamPostDAO.save(teamPostVO);
    }

    @Override
    public List<TeamPostDTO> getList(TeamPostPagination teamPostPagination) {
        return teamPostDAO.findAll(teamPostPagination);
    }

    @Override
    public int getTotal() {
        return teamPostDAO.getTotal();
    }

}
