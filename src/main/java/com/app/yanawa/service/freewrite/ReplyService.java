package com.app.yanawa.service.freewrite;

import com.app.yanawa.domain.freewrite.ReplyDTO;
import com.app.yanawa.domain.freewrite.ReplyVO;

import java.util.List;

public interface ReplyService {
    // 댓글 작성
    void write(ReplyVO replyVO);

    // 특정 게시물의 댓글 목록 조회
    List<ReplyDTO> getRepliesByPostId(Long postId);

    // 댓글 수정
    void update(ReplyVO replyVO);

    // 댓글 삭제
    void delete(Long id);
}
