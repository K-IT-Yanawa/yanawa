package com.app.yanawa.service.matching;


import com.app.yanawa.domain.matching.Pagination;
import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.Search;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamVO;

import java.util.List;
import java.util.Optional;

public interface MatchingService {
    public void write(MatchingDTO matchingDTO);
    public Optional<MemberVO> getMember(Long id);
    public Optional<TeamVO> getTeam(Long id);


    Optional<MatchingDTO> getMatchingInfoByMemberId(Long id);

    public List<MatchingDTO> getListMatching(Pagination pagination, String order, String sport, String place, String time, Search search);

    public int getTotalMatching(String sport, String place, String time, Search search);

    public int getMatchingCount();



}
