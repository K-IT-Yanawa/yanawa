package com.app.yanawa.mapper.team;

import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamPostDTO;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;


@Mapper
public interface TeamPostMapper {
//    팀 모집 글 작성
    public void insert(TeamPostVO teamPostVO);

//    팀 모집 글 전체 조회(팀 모집 글 목록)
//    public List<TeamPostDTO> selectAll(@Param("pagination") Pagination pagination, @Param("order") String order);
}

