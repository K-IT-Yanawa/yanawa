package com.app.yanawa.service.matching;

import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;
import com.app.yanawa.repository.matching.MatchingDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {
    private final MatchingDAO matchingDAO;


    @Override
    public void write(MatchingDTO matchingDTO) {matchingDAO.save(matchingDTO);}

    @Override
    public List<MatchingDTO> getListMatching() {
        return List.of();
    }

    @Override
    public int getTotalMatching() {
        return 0;
    }
}
