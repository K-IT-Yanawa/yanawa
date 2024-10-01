package com.app.yanawa.repository.team;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamPostPagination;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.mapper.team.TeamPostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TeamPostDAO {
    private final TeamPostMapper teamPostMapper;

    //    팀 모집 글 작성
    public void save(TeamPostVO teamPostVO) { teamPostMapper.insert(teamPostVO); }

    //    팀 모집 글 전체 조회(팀 모집 글 목록)
    public List<TeamPostDTO> findAll(TeamPostPagination teamPostPagination) {
        return teamPostMapper.selectAll(teamPostPagination);
    }

    //    팀 모집 글 전체 개수 조회
    public int getTotal() {
        return teamPostMapper.selectTotal();
    };
}
