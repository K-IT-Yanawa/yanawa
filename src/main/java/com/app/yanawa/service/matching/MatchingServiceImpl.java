
package com.app.yanawa.service.matching;

import com.app.yanawa.domain.matching.Pagination;
import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;
import com.app.yanawa.domain.matching.Search;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.post.PostVO;
import com.app.yanawa.domain.team.TeamVO;
import com.app.yanawa.mapper.matching.MatchingMapper;
import com.app.yanawa.repository.matching.MatchingDAO;
import com.app.yanawa.repository.post.PostDAO;
import com.app.yanawa.repository.team.TeamDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MatchingServiceImpl implements MatchingService {
    private final MatchingDAO matchingDAO;
    private final PostDAO postDAO;
    private final MatchingVO matchingVO;
    private final TeamDAO teamDAO;
    private final MatchingMapper matchingMapper;

    @Override
    public void write(MatchingDTO matchingDTO) {
        PostVO postVO = matchingDTO.toPostVO();

        postDAO.save(postVO);
        matchingDTO.setPostId(postVO.getId());
        matchingDAO.save(matchingDTO.toVO());
    }

    @Override
    public Optional<MemberVO> getMember(Long id){
        return matchingDAO.findMemberById(id);
    }
    @Override
    public Optional<TeamVO> getTeam(Long id){
        return matchingDAO.findTeamById(id);
    }

    @Override
    public Optional<MatchingDTO> getMatchingInfoByMemberId(Long id){
        return matchingDAO.getMatchingInfoByMemberId(id);
    }


    @Override
    public List<MatchingDTO> getListMatching(Pagination pagination, String order, String sport, String place, String time, Search search) {
        return matchingMapper.selectMatchingAll(pagination, order, sport, place, time, search);
    }

    @Override
    public int getTotalMatching(String sport, String place, String time, Search search) {
        return matchingDAO.getTotalMatching(sport, place, time, search);
    }

    @Override
    public int getMatchingCount() {
        return matchingDAO.getMatchingCount();
    }


}
