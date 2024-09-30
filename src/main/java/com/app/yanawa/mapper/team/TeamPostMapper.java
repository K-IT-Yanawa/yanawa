package com.app.yanawa.mapper.team;

import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamPostPagination;
import com.app.yanawa.domain.team.TeamPostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface TeamPostMapper {
//    팀 모집 글 작성
    public void insert(TeamPostVO teamPostVO);

//    팀 모집 글 전체 조회(팀 모집 글 목록)
    public List<TeamPostDTO> selectAll(TeamPostPagination teamPostPagination);

//    팀 모집 글 전체 개수 조회
    public int selectTotal();
}

