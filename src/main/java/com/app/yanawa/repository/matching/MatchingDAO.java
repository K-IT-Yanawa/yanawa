package com.app.yanawa.repository.matching;

import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;
import com.app.yanawa.domain.post.PostDTO;
import com.app.yanawa.mapper.matching.MatchingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MatchingDAO {
    private final MatchingMapper matchingMapper;


    //    매칭글 작성
    public void save(MatchingDTO matchingDTO) {
        PostDTO postDTO = new PostDTO();

        postDTO.setPostTitle(matchingDTO.getPostTitle());
        postDTO.setPostContent(matchingDTO.getPostContent());
        postDTO.setType(matchingDTO.getType());

        matchingMapper.insertPostAndMatching(postDTO, matchingDTO);

    }

}
