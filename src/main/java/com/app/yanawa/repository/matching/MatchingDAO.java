
package com.app.yanawa.repository.matching;

import com.app.yanawa.domain.matching.Pagination;
import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;
import com.app.yanawa.domain.matching.Search;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.mapper.matching.MatchingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MatchingDAO {

    private final MatchingMapper matchingMapper;

    //    매칭글 작성
    public Optional<MemberVO> findMemberById(Long id) {
        return matchingMapper.selectMemberId(id);
    }
    public Optional<TeamVO> findTeamById(Long id) {
        return matchingMapper.selectTeamId(id);
    }

    public Optional<MatchingDTO> getMatchingInfoByMemberId(Long memberId) {
        return matchingMapper.getMatchingInfoByMemberId(memberId);
    }

    public void save(MatchingVO matchingVO) {matchingMapper.insert(matchingVO);}

    //    매칭글 목록
    public List<MatchingDTO> findMatchingAll(Pagination pagination, String order, String sport, String place, String time, Search search) {
        return matchingMapper.selectMatchingAll(pagination, order, sport, place, time, search);
    }

    public int getTotalMatching(String sport, String place, String time, Search search) {
        return matchingMapper.selectMatchingTotal(sport, place, time, search);}

    public int getMatchingCount() {return matchingMapper.getMatchingCount();}
}

