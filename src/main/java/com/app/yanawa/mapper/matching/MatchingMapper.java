package com.app.yanawa.mapper.matching;

import com.app.yanawa.domain.matching.Pagination;
import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;
import com.app.yanawa.domain.matching.Search;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MatchingMapper {
    //    매칭글 작성
    public void insert(MatchingVO matchingVO);
    public Optional<MemberVO> selectMemberId(Long id);
    public Optional<TeamVO> selectTeamId(Long id);

    //    매칭글 목록
    public List<MatchingDTO> selectMatchingAll(@Param("pagination") Pagination pagination, @Param("order") String order,  @Param("sport") String sport,
                                               @Param("place") String place,
                                               @Param("time") String time, @Param("search") Search search);

    //    매칭글 전체 개수 조회
    public int selectMatchingTotal(@Param("sport") String sport,
                                   @Param("place") String place,
                                   @Param("time") String time,
                                   @Param("search") Search search);
    public int getMatchingCount();

    public Optional<MatchingDTO> getMatchingInfoByMemberId(Long memberId);
}
