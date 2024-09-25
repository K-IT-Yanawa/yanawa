<<<<<<< HEAD
=======
package com.app.yanawa.repository.matching;

import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;
import com.app.yanawa.domain.post.PostVO;
import com.app.yanawa.mapper.matching.MatchingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MatchingDAO {
    private final MatchingMapper matchingMapper;


    //    매칭글 작성
    public void save(MatchingVO matchingVO) {matchingMapper.insert(matchingVO);}

}
>>>>>>> master
