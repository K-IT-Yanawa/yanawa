package com.app.yanawa.repository.freewrite;

import com.app.yanawa.domain.freewrite.ReplyDTO;
import com.app.yanawa.domain.freewrite.ReplyVO;
import com.app.yanawa.mapper.freewrite.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {

    private final ReplyMapper replyMapper;
    private final SqlSession sqlSession;

    // 댓글 저장
    public void save(ReplyVO replyVO) {
        replyMapper.insert(replyVO);
    }

    // 댓글 ID로 조회
    public ReplyDTO findById(Long id) {
        return replyMapper.selectById(id);
    }

    // 특정 게시물의 댓글 목록 조회
    public List<ReplyDTO> findRepliesByPostId(Long postId) {
        return replyMapper.selectRepliesByPostId(postId);
    }


    // 댓글 수정
    public void update(ReplyVO replyVO) {
        replyMapper.updateReply(replyVO);
    }

    // 댓글 삭제
    public void delete(Long id) {
        replyMapper.deleteReply(id);
    }
}
