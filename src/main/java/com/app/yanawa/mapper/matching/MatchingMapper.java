package com.app.yanawa.mapper.matching;

import com.app.yanawa.domain.matching.MatchingDTO;
import com.app.yanawa.domain.matching.MatchingVO;
import com.app.yanawa.domain.post.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MatchingMapper {
//    매칭글 작성
    public void insertPostAndMatching(MatchingDTO matchingDTO);

//    매칭글 목록
    public List<MatchingVO> selectMatching(MatchingVO matchingVO);

//    매칭글 전체 개수 조회
    public int selectMatchingTotal();
}
