package com.app.yanawa.mapper.team;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.domain.team.TeamPostVO;
import com.app.yanawa.domain.team.TeamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TeamMapper {
    // 팀 등록
    public void insert(TeamVO teamVO);

    // 팀 정보 조회
    public Optional<TeamDTO> selectById(Long id);

    // 팀 전체 정보 조회
    public List<TeamVO> selectAll();

    // 팀 전체 정보 조회
    public List<MemberVO> selectAllMember();
}