
package com.app.yanawa.service.matching;

import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;
import com.app.yanawa.domain.post.PostVO;
import com.app.yanawa.repository.matching.MatchingDAO;
import com.app.yanawa.repository.post.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MatchingServiceImpl implements MatchingService {
    private final MatchingDAO matchingDAO;
    private final PostDAO postDAO;
    private final MatchingVO matchingVO;


    @Override
    public void write(MatchingDTO matchingDTO) {
        PostVO postVO = matchingDTO.toPostVO();

        postDAO.save(postVO);
        matchingDTO.setPostId(postVO.getId());
        matchingDAO.save(matchingDTO.toVO());
    }

    @Override
    public List<MatchingDTO> getListMatching() {
        return List.of();
    }

    @Override
    public int getTotalMatching() {
        return 0;
    }
}

