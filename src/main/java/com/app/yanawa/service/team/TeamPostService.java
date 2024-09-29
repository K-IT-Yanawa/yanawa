package com.app.yanawa.service.team;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamPostPagination;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;

import java.util.List;
import java.util.Optional;

public interface TeamPostService {
    public void write(TeamPostVO teamPostVO);
    public List<TeamPostDTO> getList(TeamPostPagination teamPostPagination);
    public int getTotal();
}
