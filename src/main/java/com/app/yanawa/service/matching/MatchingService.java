package com.app.yanawa.service.matching;


import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;

import java.util.List;

public interface MatchingService {
    public void write(MatchingVO matchingVO);

    public List<MatchingDTO> getListMatching();

    public int getTotalMatching();
}
